package com.linkedin.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
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
class UserServiceTest {
    private static final User USER = new User("John Doe", "test@gmail");
    @Mock
    UserRepository userRepoMock;

    @InjectMocks
    UserService userService;

    @Test
    void saveUser() {
        when(userRepoMock.save(USER)).thenReturn(USER);

        User savedUser = userService.saveUser(USER);

        assertEquals(USER, savedUser);
        verify(userRepoMock).save(USER);
    }

    @Test
    void getExistingUserById() {
        when(userRepoMock.findById(USER.getId())).thenReturn(Optional.of(USER));

        var foundUser = userService.getUserById(USER.getId());

        assertTrue(foundUser.isPresent());
        assertEquals(USER, foundUser.get());
    }

    @Test
    void getNonExistingUserById() {
        when(userRepoMock.findById(99L)).thenReturn(null);

        var foundUser = userService.getUserById(99L);

        assertNull(foundUser);
    }
}
