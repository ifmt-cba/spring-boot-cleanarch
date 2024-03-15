package br.edu.ifmt.springbootcleanarch.application.usecases;

import java.security.NoSuchAlgorithmException;

import org.springframework.beans.factory.annotation.Autowired;

import br.edu.ifmt.springbootcleanarch.application.io.CreateUserRequest;
import br.edu.ifmt.springbootcleanarch.application.io.CreateUserResponse;
import br.edu.ifmt.springbootcleanarch.application.mappers.UserDTOMapper;
import br.edu.ifmt.springbootcleanarch.domain.entities.User;
import br.edu.ifmt.springbootcleanarch.domain.ports.LogPort;
import br.edu.ifmt.springbootcleanarch.domain.services.CreateUserService;
import br.edu.ifmt.springbootcleanarch.domain.services.exception.UserException;

public class SignUpUserUseCase {

    CreateUserService createUserService;
    UserDTOMapper userDTOMapper;
    @Autowired
    private final LogPort logPort = null;
    
    public SignUpUserUseCase(CreateUserService createUserService, UserDTOMapper userDTOMapper) {
        this.createUserService = createUserService;
        this.userDTOMapper = userDTOMapper;
    }

    public CreateUserResponse signUp(CreateUserRequest request) throws NoSuchAlgorithmException, UserException {
        logPort.trace("-> SignUpUserUseCase.signUp");
        User userBusinessObj = userDTOMapper.toUser(request);
        logPort.debug(userBusinessObj.toString());
        User user = createUserService.createUser(userBusinessObj);
        logPort.trace("<- SignUpUserUseCase.signUp");
        return userDTOMapper.toResponse(user);
    } 
}
