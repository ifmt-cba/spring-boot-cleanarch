package br.edu.ifmt.springbootcleanarch.application.adapters;

import java.security.NoSuchAlgorithmException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifmt.springbootcleanarch.application.io.CreateUserRequest;
import br.edu.ifmt.springbootcleanarch.application.io.CreateUserResponse;
import br.edu.ifmt.springbootcleanarch.application.usecases.SignUpUserUseCase;
import br.edu.ifmt.springbootcleanarch.domain.ports.LogPort;
import br.edu.ifmt.springbootcleanarch.domain.services.exception.UserException;

@RestController
@RequestMapping("users")
public class UserRestAdapter {
  private final SignUpUserUseCase signUpUserUseCase;
  @Autowired
  private final LogPort logPort = null;

  public UserRestAdapter(SignUpUserUseCase signUpUserUseCase) {
    this.signUpUserUseCase = signUpUserUseCase;
  }

  @PostMapping
  public CreateUserResponse insertUser(@RequestBody CreateUserRequest request) {
    logPort.trace("-> POST /users");
    logPort.debug(request.toString());
    try {
      CreateUserResponse reply = signUpUserUseCase.signUp(request);
      logPort.debug(reply.toString());
      logPort.trace("<- POST /users>");
      return reply;
    } catch (NoSuchAlgorithmException e) {
      return new CreateUserResponse(request.username(), request.email(), e.getMessage());
    } catch (UserException e) {
      return new CreateUserResponse(request.username(), request.email(), e.getMessage());
    }
  }
}
