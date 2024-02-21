package br.edu.ifmt.springbootcleanarch.application.mappers;

import br.edu.ifmt.springbootcleanarch.application.io.CreateUserRequest;
import br.edu.ifmt.springbootcleanarch.application.io.CreateUserResponse;
import br.edu.ifmt.springbootcleanarch.domain.entities.User;

public class UserDTOMapper {
  public CreateUserResponse toResponse(User user) {
    return new CreateUserResponse(user.username(), user.email());
  }

  public User toUser(CreateUserRequest request) {
    return new User(request.username(), request.password(), request.email());
  }
}
