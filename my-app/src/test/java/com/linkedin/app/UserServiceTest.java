package com.linkedin.app;

<<<<<<< HEAD
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;

import java.sql.Timestamp;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private NotificationService notificationService;

    @InjectMocks
    private UserService underTest;

    @Captor
    private ArgumentCaptor<Timestamp> timestampCaptor;

    @Test
    public void registerUser() {
        String username = "john_doe";
        String email = "john@example.com";

        underTest.registerUser(username, email);

        verify(notificationService).send(eq("Welcome " + username),
                eq(email), timestampCaptor.capture());

        assertTrue(areWithinSeconds(new Timestamp(System.currentTimeMillis()),
                timestampCaptor.getValue(), 2));
    }

    private boolean areWithinSeconds(Timestamp timestamp1, Timestamp timestamp2, int seconds) {
        long differenceInMillis = Math.abs(timestamp1.getTime() - timestamp2.getTime());
        long differenceInSeconds = differenceInMillis / 1000;
        return differenceInSeconds <= seconds;
    }
}