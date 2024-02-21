package br.edu.ifmt.springbootcleanarch.application.adapters;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifmt.springbootcleanarch.application.io.CreateUserRequest;
import br.edu.ifmt.springbootcleanarch.application.io.CreateUserResponse;
import br.edu.ifmt.springbootcleanarch.application.usecases.SignUpUserUseCase;

@RestController
@RequestMapping("users")
public class UserRestAdapter {
  private final SignUpUserUseCase signUpUserUseCase;

  public UserRestAdapter(SignUpUserUseCase signUpUserUseCase) {
    this.signUpUserUseCase = signUpUserUseCase;
  }

  @PostMapping
  public CreateUserResponse insertUser(@RequestBody CreateUserRequest request) {
    return signUpUserUseCase.signUp(request);
  }
}
