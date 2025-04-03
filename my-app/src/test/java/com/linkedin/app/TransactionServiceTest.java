package com.linkedin.app;

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
class TransactionServiceTest {
  @InjectMocks
  private TransactionService underTest;

  @Mock
  private LoggerService loggerService;

  @Captor
  ArgumentCaptor<Timestamp> timestampCaptor;

  @Test
  void processTransaction() {
    Transaction transaction = new Transaction("TX123", 10.50);
    // ArgumentCaptor<Timestamp> timestampCaptor =
    // ArgumentCaptor.forClass(Timestamp.class);

    underTest.processTransaction(transaction);

    verify(loggerService).logMessage(eq("TX123"), eq(10.50),
        timestampCaptor.capture());

    System.out.println("Timestamp: " + timestampCaptor.getValue());
  }
}