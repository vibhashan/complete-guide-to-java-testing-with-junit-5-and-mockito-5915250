package com.linkedin.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
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
    private UserRepository userRepository;

    @InjectMocks
    private UserService underTest;

    @Test
    void getUserById() throws Exception {
        User mockUser = new User("123", "John Doe");

        when(userRepository.findById("123")).thenReturn(mockUser);

        User user = underTest.getUserById("123").get();

        assertNotNull(user);
        assertEquals("123", user.getId());
        assertEquals("John Doe", user.getName());

        verify(userRepository).findById("123");
    }
}