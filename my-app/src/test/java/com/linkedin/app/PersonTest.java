package com.linkedin.app;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class PersonTest {
	@Test
	void testPerson() {
		Person person = new Person("John Doe", 30, "jdoe@linkedin", "123 Main Street");

		assertAll("Person field getters", () -> assertEquals("John Doe", person.getName()),
				() -> assertEquals(30, person.getAge()), () -> assertEquals("jdoe@linkedin", person.getEmail()),
				() -> assertEquals("123 Main Street", person.getAddress()));

	}

}
