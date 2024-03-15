package br.edu.ifmt.springbootcleanarch.domain.entities;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.Map;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.springframework.boot.test.context.SpringBootTest;

import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
public class UserTest {
    
    @Test
    void testToString() {
        assertDoesNotThrow(new Executable() {

            @Override
            public void execute() throws Throwable {
                ObjectMapper objectMapper = new ObjectMapper();
                objectMapper.readValue(new User().toString().getBytes(),Map.class);
            }

        });

    }

}
