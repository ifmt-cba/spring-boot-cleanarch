package br.edu.ifmt.springbootcleanarch.application.mappers;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import br.edu.ifmt.springbootcleanarch.application.io.CreateUserRequest;
import br.edu.ifmt.springbootcleanarch.application.io.CreateUserResponse;
import br.edu.ifmt.springbootcleanarch.domain.entities.User;
import br.edu.ifmt.springbootcleanarch.domain.entities.vo.Email;
import br.edu.ifmt.springbootcleanarch.domain.entities.vo.Password;
import br.edu.ifmt.springbootcleanarch.domain.entities.vo.Username;

public class UserDTOMapper {

  public CreateUserResponse toResponse(User user) {
    return new CreateUserResponse(user.getUsername().toString(), user.getEmail().toString(),null);
  }

  public User toUser(CreateUserRequest request) throws NoSuchAlgorithmException {
    User user = new User();
    user.setUsername(new Username(request.username()));
    byte[] sha256 = MessageDigest.getInstance("SHA-256").digest(request.password().getBytes(StandardCharsets.UTF_8));
    user.setPassword(new Password(bytesToHex(sha256)));
    user.setEmail(new Email(request.email()));
    return user;
  }

  private static String bytesToHex(byte[] hash) {
    StringBuilder hexString = new StringBuilder(2 * hash.length);
    for (int i = 0; i < hash.length; i++) {
        String hex = Integer.toHexString(0xff & hash[i]);
        if(hex.length() == 1) {
            hexString.append('0');
        }
        hexString.append(hex);
    }
    return hexString.toString();
}
}
