package com.linkedin.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

public class UserServiceTest {

  @Test
  public void findUserById() {
    UserRepository userRepositoryMock = mock(UserRepository.class);

    User mockUser = new User("1", "John Doe");
    when(userRepositoryMock.findById("1")).thenReturn(mockUser);

    UserService underTest = new UserService(userRepositoryMock);

    User result = underTest.findUserById("1");

    assertEquals(mockUser, result);
    verify(userRepositoryMock).findById("1");
  }
}
