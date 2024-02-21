package br.edu.ifmt.springbootcleanarch.main;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.edu.ifmt.springbootcleanarch.application.mappers.UserDTOMapper;
import br.edu.ifmt.springbootcleanarch.domain.ports.UserPort;
import br.edu.ifmt.springbootcleanarch.domain.usecases.CreateUserUseCase;
import br.edu.ifmt.springbootcleanarch.infrastructure.adapters.UserRepositoryAdapter;
import br.edu.ifmt.springbootcleanarch.infrastructure.mappers.UserEntityMapper;
import br.edu.ifmt.springbootcleanarch.infrastructure.persistence.UserRepository;

@Configuration
public class UserConfig {
  @Bean
  CreateUserUseCase createUserCase(UserPort userPort) {
    return new CreateUserUseCase(userPort);
  }

  @Bean
  UserPort userPort(UserRepository userRepository, UserEntityMapper userEntityMapper) {
    return new UserRepositoryAdapter(userRepository, userEntityMapper);
  }

  @Bean
  UserEntityMapper userEntityMapper() {
    return new UserEntityMapper();
  }

  @Bean
  UserDTOMapper userDTOMapper() {
    return new UserDTOMapper();
  }
}
