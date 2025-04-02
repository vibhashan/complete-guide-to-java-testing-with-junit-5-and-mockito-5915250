package com.linkedin.app;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ShoppingCartTest {
	private static ShoppingCart cart;

	@BeforeEach
	void beforeEach() {
		cart = new ShoppingCart();
	}

	@AfterEach
	void afterEach() {
		cart = null;
	}

	@Test
	void addItem() {
		cart.addItem("Product A", 2);
		cart.addItem("Product C", 3);
		assertEquals(5, cart.getTotalItems());
	}

	@Test
	void removeItem() {
		cart.addItem("Product A", 2);
		cart.removeItem("Product A", 1);
		assertEquals(1, cart.getTotalItems());
	}
}