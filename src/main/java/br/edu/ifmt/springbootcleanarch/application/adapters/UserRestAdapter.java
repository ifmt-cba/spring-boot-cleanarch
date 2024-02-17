package br.edu.ifmt.springbootcleanarch.application.adapters;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifmt.springbootcleanarch.domain.model.User;
import br.edu.ifmt.springbootcleanarch.domain.usecases.CreateUserUseCase;

@RestController
@RequestMapping("users")
public class UserRestAdapter {
  private final CreateUserUseCase createUserUseCase;
  private final UserDTOMapper userDTOMapper;

  public UserRestAdapter(CreateUserUseCase createUserUseCase,
      UserDTOMapper userDTOMapper) {
    this.createUserUseCase = createUserUseCase;
    this.userDTOMapper = userDTOMapper;
  }

  @PostMapping
  public CreateUserResponse createUser(@RequestBody CreateUserRequest request) {
    User userBusinessObj = userDTOMapper.toUser(request);
    User user = createUserUseCase.createUser(userBusinessObj);
    return userDTOMapper.toResponse(user);
  }
}
