package com.linkedin.app;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class ShoppingCartTest {
  private static ShoppingCart cart = new ShoppingCart();

  @Test
  public void addItem() {
    cart.addItem("Product A", 2);
    cart.addItem("Product C", 3);
    assertEquals(5, cart.getTotalItems());
  }

  @Test
  public void removeItem() {
    cart.addItem("Product A", 2);
    cart.removeItem("Product A", 1);
    assertEquals(1, cart.getTotalItems());
  }
}