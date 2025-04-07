package com.linkedin.app;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doThrow;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class DatabaseServiceTest {
    @Mock
    private DatabaseConnection dbConnectionMock;

    @InjectMocks
    private DatabaseService underTest;

    @Test
    void databaseConnectionFailure() throws Exception {
        doThrow(DatabaseException.class).when(dbConnectionMock).getConnection(); // Stub the getConnection() method to
                                                                                 // throw an exception.
                                                                                 //
                                                                                 //

        assertThrows(DatabaseException.class, () -> underTest.getData());
    }
}