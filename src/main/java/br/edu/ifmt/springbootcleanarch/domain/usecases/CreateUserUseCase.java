package br.edu.ifmt.springbootcleanarch.domain.usecases;

import br.edu.ifmt.springbootcleanarch.domain.entities.User;
import br.edu.ifmt.springbootcleanarch.domain.ports.UserPort;

public class CreateUserUseCase {
  private final UserPort userPort;

  public CreateUserUseCase(UserPort createUser) {
    this.userPort = createUser;
  }

  public User createUser(User user) {
    return userPort.createUser(user);
  }
}
