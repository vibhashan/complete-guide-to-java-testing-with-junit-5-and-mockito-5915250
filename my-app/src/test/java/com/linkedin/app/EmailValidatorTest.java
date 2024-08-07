package com.linkedin.app;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class EmailValidatorTest {

  private static final EmailValidator underTest = new EmailValidator();

  @ParameterizedTest
  @ValueSource(strings = {
      "user@example.com",
      "user.name@example.com",
      "user123@example.com",
      "user_name@example.com"
  })
  public void valid(String email) {
    assertTrue(underTest.isValid(email));
  }

  @ParameterizedTest
  @ValueSource(strings = {
      "user@",
      "@example.com",
      "user@.com",
      "user@exa_mple.com",
      "user@ex!ample.com",
      "user@example",
      "user@example.",
      "user@.123",
      "user@example.123",
      "user@example.12_3"
  })
  public void invalid(String email) {
    assertFalse(underTest.isValid(email));
  }

}
