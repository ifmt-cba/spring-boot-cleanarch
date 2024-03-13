package br.edu.ifmt.springbootcleanarch.infrastructure.mappers;

import br.edu.ifmt.springbootcleanarch.domain.entities.User;
import br.edu.ifmt.springbootcleanarch.domain.entities.vo.Email;
import br.edu.ifmt.springbootcleanarch.domain.entities.vo.Password;
import br.edu.ifmt.springbootcleanarch.domain.entities.vo.Username;
import br.edu.ifmt.springbootcleanarch.infrastructure.persistence.UserORM;

public class UserORMMapper {
  public UserORM toORM(User userDomainObj) {
    return new UserORM(userDomainObj.getUsername().toString(), userDomainObj.getPassword().toString(), userDomainObj.getEmail().toString());
  }

  public User toDomainObj(UserORM userORM) {
    User user = new User();
    user.setUsername(new Username(userORM.getUsername()));
    user.setPassword(new Password(userORM.getPassword()));
    user.setEmail(new Email(userORM.getEmail()));
    return user;
  }

}
