package br.edu.ifmt.springbootcleanarch.infrastructure.adapters;

import br.edu.ifmt.springbootcleanarch.domain.entities.User;
import br.edu.ifmt.springbootcleanarch.domain.ports.UserPort;
import br.edu.ifmt.springbootcleanarch.infrastructure.mappers.UserORMMapper;
import br.edu.ifmt.springbootcleanarch.infrastructure.persistence.UserORM;
import br.edu.ifmt.springbootcleanarch.infrastructure.persistence.UserRepository;

public class UserRepositoryAdapter implements UserPort {
  private final UserRepository userRepository;
  private final UserORMMapper userORMMapper;

  public UserRepositoryAdapter(UserRepository userRepository, UserORMMapper userORMMapper) {
    this.userRepository = userRepository;
    this.userORMMapper = userORMMapper;
  }

  @Override
  public User createUser(User userDomainObj) {
    UserORM userORM = userORMMapper.toORM(userDomainObj);
    UserORM savedUser = userRepository.save(userORM);

    return userORMMapper.toDomainObj(savedUser);
  }

}
