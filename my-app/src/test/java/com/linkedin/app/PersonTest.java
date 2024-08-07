package com.linkedin.app;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class PersonTest {

  @Test
  public void personFields() {
    Person person = new Person("John Doe", 30, "john.doe@example.com", "123 Main St");
    assertAll("Person fields",
        () -> assertEquals("John Doe", person.getName()),
        () -> assertEquals(29, person.getAge()),
        () -> assertEquals("john.do@example.com", person.getEmail()),
        () -> assertEquals("123 Main St", person.getAddress()));
  }
}
