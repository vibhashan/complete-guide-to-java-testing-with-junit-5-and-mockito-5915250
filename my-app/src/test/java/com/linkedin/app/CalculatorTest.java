package com.linkedin.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class CalculatorTest {
	@Test
	void add() {
		assertEquals(5, Calculator.add(2, 3), "Result should be 5");
		assertEquals(0, Calculator.add(0, 0), "Result should be 0");
		assertEquals(-8, Calculator.add(-5, -3), "Result should be -8");
		assertEquals(-3, Calculator.add(-5, 2), "Result should be -3");
	}

	@Test
	void division() {
		int result = Calculator.divide(6, 2);
		assertEquals(3, result, "Result should be 3");
	}

	@Test
	void isEven() {
		boolean result = Calculator.isEven(4);
		assertTrue(result, "Result should be true since 4 is even");

		result = Calculator.isEven(5);
		assertFalse(result, "Result should be false since 5 is odd");
	}

	@Test
	void nullCheck() {
		Integer result = null;
		try {
			result = Calculator.divide(5, 0);
		} catch (ArithmeticException e) {
			System.out.println(e.getMessage());
		}

		assertNull(result, "Result should be null due to exception");
	}
}
