package br.edu.ifmt.springbootcleanarch.infrastructure.adapters;

import org.springframework.beans.factory.annotation.Autowired;

import br.edu.ifmt.springbootcleanarch.domain.entities.User;
import br.edu.ifmt.springbootcleanarch.domain.ports.LogPort;
import br.edu.ifmt.springbootcleanarch.domain.ports.UserPort;
import br.edu.ifmt.springbootcleanarch.infrastructure.mappers.UserORMMapper;
import br.edu.ifmt.springbootcleanarch.infrastructure.persistence.UserORM;
import br.edu.ifmt.springbootcleanarch.infrastructure.persistence.UserRepository;

public class UserRepositoryAdapter implements UserPort {
  private final UserRepository userRepository;
  private final UserORMMapper userORMMapper;
  @Autowired
  private final LogPort logPort = null;

  public UserRepositoryAdapter(UserRepository userRepository, UserORMMapper userORMMapper) {
    this.userRepository = userRepository;
    this.userORMMapper = userORMMapper;
  }

  @Override
  public User createUser(User userDomainObj) {
    logPort.trace("-> UserRepositoryAdapter.createUser");
    UserORM userORM = userORMMapper.toORM(userDomainObj);
    logPort.debug(userORM.toString());
    UserORM savedUser = userRepository.save(userORM);
    logPort.info("User inserted in table user.");
    logPort.debug(userORM.toString());
    logPort.trace("<- UserRepositoryAdapter.createUser");
    return userORMMapper.toDomainObj(savedUser);
  }

}
