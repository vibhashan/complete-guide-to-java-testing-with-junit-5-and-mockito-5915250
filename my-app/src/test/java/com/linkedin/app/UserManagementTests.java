package com.linkedin.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(OrderAnnotation.class)
class UserManagementTests {

	private static User testUser;
	private static UserService userService = new UserService();

	@Test
	@Order(3)
	void updateUser() {
		assertNotNull(testUser, "Test user should exist");
		testUser.setFirstName("Joe");
		testUser.setLastName("Smith");
		userService.updateUser(testUser);
		User updatedUser = userService.getUserById(testUser.getId());
		assertEquals("Joe", updatedUser.getFirstName(), "First name should be updated");
		assertEquals("Smith", updatedUser.getLastName(), "Last name should be updated");
		System.out.println("Update User Test");
	}

	@Test
	@Order(1)
	void createUser() {
		testUser = new User("john_smith", "John", "Smith", "john.doe@example.com");
		userService.createUser(testUser);
		assertNotNull(testUser.getId(), "User ID should be generated");
		System.out.println("Create User Test");
	}

	@Test
	@Order(2)
	void getUser() {
		assertNotNull(testUser, "Test user should exist");
		User fetchedUser = userService.getUserById(testUser.getId());
		assertNotNull(fetchedUser, "Fetched user should not be null");
		assertEquals(testUser.getId(), fetchedUser.getId(), "User ID should match");
		System.out.println("Get User Test");
	}

	@Test
	@Order(4)
	void deleteUser() {
		assertNotNull(testUser, "Test user should exist");
		userService.deleteUser(testUser.getId());
		User deletedUser = userService.getUserById(testUser.getId());
		assertNull(deletedUser, "Deleted user should be null");
		System.out.println("Delete User Test");
	}
}
