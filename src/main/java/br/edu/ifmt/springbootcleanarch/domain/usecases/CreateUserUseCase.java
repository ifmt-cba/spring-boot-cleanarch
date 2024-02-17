package br.edu.ifmt.springbootcleanarch.domain.usecases;

import br.edu.ifmt.springbootcleanarch.domain.ports.UserPort;
import br.edu.ifmt.springbootcleanarch.domain.model.User;

public class CreateUserUseCase {
  private final UserPort userPort;

  public CreateUserUseCase(UserPort createUser) {
    this.userPort = createUser;
  }

  public User createUser(User user) {
    return userPort.createUser(user);
  }
}
