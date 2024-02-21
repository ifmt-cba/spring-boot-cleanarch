package br.edu.ifmt.springbootcleanarch.infrastructure.mappers;

import br.edu.ifmt.springbootcleanarch.domain.entities.User;
import br.edu.ifmt.springbootcleanarch.infrastructure.persistence.UserORM;

public class UserORMMapper {
  public UserORM toORM(User userDomainObj) {
    return new UserORM(userDomainObj.username(), userDomainObj.password(), userDomainObj.email());
  }

  public User toDomainObj(UserORM userORM) {
    return new User(userORM.getUsername(), userORM.getPassword(), userORM.getEmail());
  }

}
