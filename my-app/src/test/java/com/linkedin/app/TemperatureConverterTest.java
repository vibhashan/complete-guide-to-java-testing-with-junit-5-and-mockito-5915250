package com.linkedin.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class TemperatureConverterTest {

  @Test
  public void celsiusToFahrenheit() {
    assertEquals(32, TemperatureConverter.celsiusToFahrenheit(0.0));
  }

  @Test
  public void celsiusToFahrenheit_celsiusTooLow() {
    IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> {
      TemperatureConverter.celsiusToFahrenheit(-300.0);
    });
    assertEquals("Temperature cannot be below absolute zero (-273.15°C)",
        e.getMessage());
  }

  @Test
  public void fahrenheitToCelsius() {
    assertEquals(100.0, TemperatureConverter.fahrenheitToCelsius(212.0));
  }

  @Test
  public void fahrenheitToCelsius_fahrenheitTooLow() {
    IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> {
      TemperatureConverter.fahrenheitToCelsius(-500.0);
    });
    assertEquals("Temperature cannot be below absolute zero (-459.67°F)",
        e.getMessage());
  }
}
