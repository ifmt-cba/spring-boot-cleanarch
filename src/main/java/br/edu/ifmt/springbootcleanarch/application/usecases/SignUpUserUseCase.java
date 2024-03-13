package br.edu.ifmt.springbootcleanarch.application.usecases;

import java.security.NoSuchAlgorithmException;

import br.edu.ifmt.springbootcleanarch.application.io.CreateUserRequest;
import br.edu.ifmt.springbootcleanarch.application.io.CreateUserResponse;
import br.edu.ifmt.springbootcleanarch.application.mappers.UserDTOMapper;
import br.edu.ifmt.springbootcleanarch.domain.entities.User;
import br.edu.ifmt.springbootcleanarch.domain.services.CreateUserService;
import br.edu.ifmt.springbootcleanarch.domain.services.exception.UserException;

public class SignUpUserUseCase {

    CreateUserService createUserService;
    UserDTOMapper userDTOMapper;

    public SignUpUserUseCase(CreateUserService createUserService, UserDTOMapper userDTOMapper) {
        this.createUserService = createUserService;
        this.userDTOMapper = userDTOMapper;
    }

    public CreateUserResponse signUp(CreateUserRequest request) throws NoSuchAlgorithmException, UserException {
        User userBusinessObj = userDTOMapper.toUser(request);
        
        User user = createUserService.createUser(userBusinessObj);

        return userDTOMapper.toResponse(user);
    } 
}
