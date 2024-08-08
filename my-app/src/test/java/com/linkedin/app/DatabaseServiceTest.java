package com.linkedin.app;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

public class DatabaseServiceTest {

    @Mock
    private DatabaseConnection dbConnectionMock;

    @InjectMocks
    private DatabaseService underTest;

    @Test
    public void databaseConnectionFailure() throws Exception {
        assertThrows(DatabaseException.class, () -> underTest.getData());
    }
}