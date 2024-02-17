package br.edu.ifmt.springbootcleanarch.application.adapters;

import br.edu.ifmt.springbootcleanarch.domain.model.User;

public class UserDTOMapper {
  CreateUserResponse toResponse(User user) {
    return new CreateUserResponse(user.username(), user.email());
  }

  public User toUser(CreateUserRequest request) {
    return new User(request.username(), request.password(), request.email());
  }
}
