package com.linkedin.app;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class StringUtilsTest {
	@ParameterizedTest
	@ValueSource(strings = { "", "a", "racecar", "RaceCar" })
	void isPalindrome(String str) {
		assertTrue(StringUtils.isPalindrome(str));
	}

	@ParameterizedTest
	@ValueSource(strings = { "hello" })
	void isNotPalindrome(String str) {
		assertFalse(StringUtils.isPalindrome(str));
	}

//	@Test
//	void isPalindromeWithEmptyString() {
//		assertTrue(StringUtils.isPalindrome(""));
//	}
//
//	@Test
//	void isPalindromeWithSingleCharacter() {
//		assertTrue(StringUtils.isPalindrome("a"));
//	}
//
//	@Test
//	void isPalindromeWithPalindromeString() {
//		assertTrue(StringUtils.isPalindrome("racecar"));
//	}
//
//	@Test
//	void isPalindromeWithNonPalindromeString() {
//		assertFalse(StringUtils.isPalindrome("hello"));
//	}
//
//	@Test
//	void isPalindromeWithMixedCasePalindromeString() {
//		assertTrue(StringUtils.isPalindrome("RaceCar"));
//	}
}