package br.edu.ifmt.springbootcleanarch.infrastructure.adapters;

import br.edu.ifmt.springbootcleanarch.domain.model.User;
import br.edu.ifmt.springbootcleanarch.infrastructure.persistence.UserEntity;

public class UserEntityMapper {
  UserEntity toEntity(User userDomainObj) {
    return new UserEntity(userDomainObj.username(), userDomainObj.password(), userDomainObj.email());
  }

  User toDomainObj(UserEntity userEntity) {
    return new User(userEntity.getUsername(), userEntity.getPassword(), userEntity.getEmail());
  }

}
