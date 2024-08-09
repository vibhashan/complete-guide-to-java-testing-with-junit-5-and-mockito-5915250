package com.linkedin.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

  @Mock
  private UserRepository userRepository;

  @InjectMocks
  private UserService underTest;

  private final User USER = new User("John Doe", "john.doe@example.com");

  @Test
  public void saveUser() {
    when(userRepository.save(USER)).thenReturn(USER);

    User savedUser = underTest.saveUser(USER);

    assertEquals(USER, savedUser);
    verify(userRepository).save(USER);
  }

  @Test
  public void getUserById() {
    when(userRepository.findById(USER.getId())).thenReturn(Optional.of(USER));
    Optional<User> foundUser = underTest.getUserById(USER.getId());
    assertTrue(foundUser.isPresent());
    assertEquals(USER, foundUser.get());
    verify(userRepository).findById(USER.getId());
  }
}
