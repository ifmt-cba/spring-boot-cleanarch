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
    this.excRB = ResourceBundle.getBundle("resources/exceptions", new Locale("pt","BR"));
  }

  public User createUser(User user) throws UserException {
    if (user.getUsername() == null)
      throw new UserException(excRB.getString("user.username.invalid"));

    if (user.getEmail() == null)
      throw new UserException("user.email.invalid");
      
    if (user.getPassword() == null)
      throw new UserException("user.password.invalid"); 

    return userPort.createUser(user);
  }
}
