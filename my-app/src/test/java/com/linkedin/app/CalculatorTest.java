package com.linkedin.app;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CalculatorTest {

  private Calculator underTest = new Calculator();
  
  // Test Add
  @Test
  public void addition() {
    int result = underTest.add(2, 3);
    assertEquals(5, result);
  }
}
