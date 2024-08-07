package com.linkedin.app;

import org.junit.jupiter.api.Test;

public class TimeoutTest {

  @Test
  void methodWithTimeout() throws InterruptedException {
    // Perform test logic that should complete within 5 seconds
    Thread.sleep(6000); // Simulating a lengthy operation
  }
}