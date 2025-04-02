package com.linkedin.app;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ShoppingCartTest {
	private static ShoppingCart cart;

	@BeforeEach
	void setUp() {
		cart = new ShoppingCart();
		cart.addItem("Product A", 2);
	}

	@Test
	void addItem() {
		cart.addItem("Product C", 4);
		assertEquals(6, cart.getTotalItems());
	}

	@Test
	void removeItem() {
		cart.removeItem("Product A", 1);
		assertEquals(1, cart.getTotalItems());
	}

	@AfterEach
	void teardown() {
		cart = null;
	}
}