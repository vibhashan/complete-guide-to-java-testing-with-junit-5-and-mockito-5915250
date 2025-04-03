package com.linkedin.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class) // Interoperability with Junit 5
class UserServiceTest {
  @Mock // New way of mocking
  private UserRepository userRepositoryMock;

  @InjectMocks // Automatically injects mocks
  private UserService underTest;

  @Test
  void findUserById() {
    // Option 1: Traditional mockito mocking
    // UserRepository userRepositoryMock = mock(UserRepository.class);

    User mockUser = new User("1", "John Doe");
    when(userRepositoryMock.findById("1")).thenReturn(mockUser); // Specify mock behavior

    // UserService underTest = new UserService(userRepositoryMock);

    User result = underTest.findUserById("1");

    assertEquals(mockUser, result);
    verify(userRepositoryMock).findById("1");
  }
}
