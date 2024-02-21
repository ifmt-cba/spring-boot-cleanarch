package br.edu.ifmt.springbootcleanarch.infrastructure.mappers;

import br.edu.ifmt.springbootcleanarch.domain.model.User;
import br.edu.ifmt.springbootcleanarch.infrastructure.persistence.UserEntity;

public class UserEntityMapper {
  public UserEntity toEntity(User userDomainObj) {
    return new UserEntity(userDomainObj.username(), userDomainObj.password(), userDomainObj.email());
  }

  public User toDomainObj(UserEntity userEntity) {
    return new User(userEntity.getUsername(), userEntity.getPassword(), userEntity.getEmail());
  }

}
