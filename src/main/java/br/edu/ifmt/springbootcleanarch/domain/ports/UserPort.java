package br.edu.ifmt.springbootcleanarch.domain.ports;

import br.edu.ifmt.springbootcleanarch.domain.model.User;

public interface UserPort {
  User createUser(User user);
}
