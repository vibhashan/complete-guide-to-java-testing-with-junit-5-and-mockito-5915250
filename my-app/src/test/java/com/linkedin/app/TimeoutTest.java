package com.linkedin.app;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

public class TimeoutTest {

	@Test
	@Timeout(value = 5, unit = TimeUnit.SECONDS)
	void methodWithTimeout() throws InterruptedException {
		// Perform test logic that should complete within 5 seconds
		Thread.sleep(4000); // Simulating a lengthy operation
	}
}