package br.edu.ifmt.springbootcleanarch.domain.services;

import br.edu.ifmt.springbootcleanarch.domain.entities.User;
import br.edu.ifmt.springbootcleanarch.domain.ports.UserPort;
import br.edu.ifmt.springbootcleanarch.domain.services.exception.UserException;

public class CreateUserService {
  
  private final UserPort userPort;

  public CreateUserService(UserPort createUser) {
    this.userPort = createUser;
  }

  public User createUser(User user) throws UserException {
    if (user.getUsername() == null)
      throw new UserException("Invalid username!");

    if (user.getEmail() == null)
      throw new UserException("Invalid e-mail!");
      
    if (user.getPassword() == null)
      throw new UserException("Invalid password!"); 

    return userPort.createUser(user);
  }
}
