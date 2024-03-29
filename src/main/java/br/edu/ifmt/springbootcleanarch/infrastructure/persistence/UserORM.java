package br.edu.ifmt.springbootcleanarch.infrastructure.persistence;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("USER")
public class UserORM {
  @Id
  private Long id;
  private String username;
  private String password;
  private String email;

  public UserORM() {

  }

  public UserORM(String username, String password, String email) {
    this.username = username;
    this.password = password;
    this.email = email;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  @Override
  public String toString() {
      return String.format("{\"id\":\"%d\",\"username\":\"%s\",\"email\":\"%s\",\"password\":\"%s\"}",
        this.id, 
        this.username,
        this.email,
        this.password);
  }
}
