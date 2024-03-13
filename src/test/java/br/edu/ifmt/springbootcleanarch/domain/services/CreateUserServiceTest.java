package br.edu.ifmt.springbootcleanarch.domain.services;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import br.edu.ifmt.springbootcleanarch.domain.entities.User;
import br.edu.ifmt.springbootcleanarch.domain.ports.UserPort;
import br.edu.ifmt.springbootcleanarch.domain.services.exception.UserException;

@SpringBootTest
public class CreateUserServiceTest {
    static CreateUserService createUserService;
    
    @BeforeAll
    static void init() {
        createUserService = new CreateUserService(new UserPort() {

            @Override
            public User createUser(User user) {
                return user;
            }
            
        });
    }

    @Test
    void shouldThrowException() {
        assertThrows(UserException.class, () -> {
            createUserService.createUser(new User());
        }); 
    }

}
