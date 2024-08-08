package com.linkedin.app;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class UserRepositoryTest {

  private final User USER = new User("John Doe", "john.doe@example.com");
  
  @Autowired
  private UserRepository underTest;

  @Test
  public void saveUser() {
    User savedUser = underTest.save(USER);
    assertEquals(USER, savedUser);
  }

  @Test
  public void findById() {
    User savedUser = underTest.save(USER);
    User foundUser = underTest.findById(savedUser.getId()).orElse(null);
    assertEquals(USER, foundUser);
  }
}
