package com.linkedin.app;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class EmailValidatorTest {
	private static EmailValidator emailValidator;

	@BeforeAll
	static void beforeAll() {
		emailValidator = new EmailValidator();
	}

	@AfterAll
	static void afterAll() {
		emailValidator = null;
	}

	@ParameterizedTest
	@ValueSource(strings = { "user@example.com", "user.name@example.com", "user123@example.com",
			"user_name@example.com" })
	void validEmails(String email) {
		assertTrue(emailValidator.isValid(email));
	}

	@ParameterizedTest
	@ValueSource(strings = { "user@", "@example.com", "user@.com", "user@exa_mple.com", "user@example.",
			"user@example.123", "user@example", "", "$51@gmail.com" })
	void invalidEmails(String email) {
		assertFalse(emailValidator.isValid(email));
	}
}
