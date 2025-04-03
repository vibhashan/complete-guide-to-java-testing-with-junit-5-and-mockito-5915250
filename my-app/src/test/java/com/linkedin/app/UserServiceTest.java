package com.linkedin.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {
  @Mock
  private UserRepository userRepositoryMock;

  @InjectMocks
  private UserService underTest;

  @Test
  void findUserById() {
    User mockUser = new User("1", "John Doe");
    when(userRepositoryMock.findById("1")).thenReturn(mockUser);

    User result = underTest.findUserById("1");

    assertEquals(mockUser, result);
    verify(userRepositoryMock).findById("1");
  }

  @Test
  void findUserById_nonExistent() {
    when(userRepositoryMock.findById("3")).thenReturn(null);
    assertNull(underTest.findUserById("3"));
  }

  @Test
  void findUserByIdNonExisting() {
    when(userRepositoryMock.findById("2")).thenReturn(null); // Specify mocking behavior (also know as "stubbing").
    assertNull(underTest.findUserById("2"));
    verify(userRepositoryMock).findById("2"); // Verify that userRepositoryMock.findById("2") was called once.
  }

  @Test
  void findUserByIdMultipleUsers() {
    User user1 = new User("1", "John Doe");
    User user2 = new User("2", "Jane Doe");

    when(userRepositoryMock.findById("1")).thenReturn(user1);
    when(userRepositoryMock.findById("2")).thenReturn(user2);

    assertNotNull(underTest.findUserById("1"));
    assertNotNull(underTest.findUserById("2"));

    verify(userRepositoryMock).findById("1");
    verify(userRepositoryMock).findById("2");
  }

}
