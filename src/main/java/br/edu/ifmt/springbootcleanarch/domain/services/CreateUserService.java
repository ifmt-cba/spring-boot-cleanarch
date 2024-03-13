package br.edu.ifmt.springbootcleanarch.domain.services;

import java.util.Locale;
import java.util.ResourceBundle;

import br.edu.ifmt.springbootcleanarch.domain.entities.User;
import br.edu.ifmt.springbootcleanarch.domain.ports.UserPort;
import br.edu.ifmt.springbootcleanarch.domain.services.exception.UserException;

public class CreateUserService {
  private ResourceBundle excRB;
  private final UserPort userPort;

  public CreateUserService(UserPort createUser) {
    this.userPort = createUser;
    this.excRB = ResourceBundle.getBundle("exceptions", new Locale("pt","BR"));
  }

  public User createUser(User user) throws UserException {
    if (user.getUsername().toString() == null)
      throw new UserException(excRB.getString("user.username.invalid"));

    if (user.getEmail().toString() == null)
      throw new UserException(excRB.getString("user.email.invalid"));
      
    if (user.getPassword().toString() == null)
      throw new UserException(excRB.getString("user.password.invalid")); 

    return userPort.createUser(user);
  }
}
