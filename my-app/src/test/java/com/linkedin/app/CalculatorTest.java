package com.linkedin.app;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CalculatorTest {

	@Test
	void add() {
		Calculator calculator = new Calculator();
		int result = calculator.add(2, 3);

		// Using of lambda expression (message suppliers) are more efficient since it
		// only constructs the message for a failure
		// preventing unnecessary object creation
		assertEquals(5, result, () -> "Expected 5 but got " + result);
	}
}
