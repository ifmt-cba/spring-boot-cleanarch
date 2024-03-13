package br.edu.ifmt.springbootcleanarch.ioc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.edu.ifmt.springbootcleanarch.application.mappers.UserDTOMapper;
import br.edu.ifmt.springbootcleanarch.application.usecases.SignUpUserUseCase;
import br.edu.ifmt.springbootcleanarch.domain.ports.UserPort;
import br.edu.ifmt.springbootcleanarch.domain.services.CreateUserService;
import br.edu.ifmt.springbootcleanarch.infrastructure.adapters.UserRepositoryAdapter;
import br.edu.ifmt.springbootcleanarch.infrastructure.mappers.UserORMMapper;
import br.edu.ifmt.springbootcleanarch.infrastructure.persistence.UserRepository;

@Configuration
public class UserDI {

  @Bean
  SignUpUserUseCase signUpUserUseCase(CreateUserService createUSerService, UserDTOMapper userDTOMapper) {
    return new SignUpUserUseCase(createUSerService, userDTOMapper);
  }

  @Bean
  CreateUserService createUserService(UserPort userPort) {
    return new CreateUserService(userPort);
  }

  @Bean
  UserPort userPort(UserRepository userRepository, UserORMMapper userORMMapper) {
    return new UserRepositoryAdapter(userRepository, userORMMapper);
  }

  @Bean
  UserORMMapper userORMMapper() {
    return new UserORMMapper();
  }

  @Bean
  UserDTOMapper userDTOMapper() {
    return new UserDTOMapper();
  }
}
