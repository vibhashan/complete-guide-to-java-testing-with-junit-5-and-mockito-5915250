package com.linkedin.app;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AdditionTest {
	@Test
	@DisplayName("Addition should return the correct sum")
	void addition() {
		int result = 2 + 2;
		assertEquals(4, result, "2 + 2 should equal 4");
	}
}