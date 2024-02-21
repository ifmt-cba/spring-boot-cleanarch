package br.edu.ifmt.springbootcleanarch.domain.services;

import br.edu.ifmt.springbootcleanarch.domain.entities.User;
import br.edu.ifmt.springbootcleanarch.domain.ports.UserPort;

public class CreateUserService {
  private final UserPort userPort;

  public CreateUserService(UserPort createUser) {
    this.userPort = createUser;
  }

  public User createUser(User user) {
    return userPort.createUser(user);
  }
}
