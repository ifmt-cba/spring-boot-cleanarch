package br.edu.ifmt.springbootcleanarch.domain.ports;

import br.edu.ifmt.springbootcleanarch.domain.entities.User;

public interface UserPort {
  User createUser(User user);
}
