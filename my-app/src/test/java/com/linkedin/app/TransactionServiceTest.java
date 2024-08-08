package com.linkedin.app;

import static org.mockito.Mockito.verify;

import java.sql.Timestamp;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class TransactionServiceTest {

  @InjectMocks
  private TransactionService underTest;

  @Mock
  private LoggerService loggerService;

  @Test
  public void processTransaction() {
    Transaction transaction = new Transaction("TX123", 10.50);

    underTest.processTransaction(transaction);

    verify(loggerService).logMessage("TX123", 10.50,
        new Timestamp(System.currentTimeMillis()));
  }
}