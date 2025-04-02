package com.linkedin.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TaskTest {
	private static Task task;

	@BeforeAll
	static void beforeAll() {
		task = new Task();
	}

	@BeforeEach
	void beforeEach() {
		task.setDescription("Initial description");
	}

	@AfterAll
	static void afterAll() {
		task = null;
	}

	@AfterEach
	void afterEach() {
		task.setDescription("");
	}

	@Test
	void getId() {
		assertNotNull(task.getId());
	}

	@Test
	void getDescription() {
		assertEquals("Initial description", task.getDescription());
	}

	@Test
	void updateDescription() {
		assertEquals("Initial description", task.getDescription());

		String description = "Updated description";
		task.updateDescription(description);

		assertEquals(description, task.getDescription());
	}
}
