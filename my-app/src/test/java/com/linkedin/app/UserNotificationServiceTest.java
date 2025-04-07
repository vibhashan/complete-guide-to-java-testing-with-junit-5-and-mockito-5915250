package com.linkedin.app;

import java.util.logging.Logger;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class UserNotificationServiceTest {

    @Mock
    private EmailService emailService;

    @Mock
    private Logger logger;

    @InjectMocks
    private UserNotificationService underTest;

    private static final String EMAIL = "test@example.com";
    private static final String MESSAGE = "Hello, User!";

    @Test
    void notifyUser() throws EmailException {

    }

    @Test
    void notifyUser_EmailException() throws EmailException {

    }
}