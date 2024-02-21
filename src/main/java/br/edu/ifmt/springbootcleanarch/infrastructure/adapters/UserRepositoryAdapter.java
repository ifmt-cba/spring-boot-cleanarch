package br.edu.ifmt.springbootcleanarch.infrastructure.adapters;

import br.edu.ifmt.springbootcleanarch.domain.model.User;
import br.edu.ifmt.springbootcleanarch.domain.ports.UserPort;
import br.edu.ifmt.springbootcleanarch.infrastructure.mappers.UserEntityMapper;
import br.edu.ifmt.springbootcleanarch.infrastructure.persistence.UserEntity;
import br.edu.ifmt.springbootcleanarch.infrastructure.persistence.UserRepository;

public class UserRepositoryAdapter implements UserPort {
  private final UserRepository userRepository;
  private final UserEntityMapper userEntityMapper;

  public UserRepositoryAdapter(UserRepository userRepository, UserEntityMapper userEntityMapper) {
    this.userRepository = userRepository;
    this.userEntityMapper = userEntityMapper;
  }

  @Override
  public User createUser(User userDomainObj) {
    UserEntity userEntity = userEntityMapper.toEntity(userDomainObj);
    UserEntity savedEntity = userRepository.save(userEntity);

    return userEntityMapper.toDomainObj(savedEntity);
  }

}
