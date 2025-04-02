package com.linkedin.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class TemperatureConverterTest {
	private static double celsius;
	private static double fahrenheit;

	@BeforeAll
	static void beforeAll() {
		celsius = -273.15;
		fahrenheit = -459.67;
	}

	@AfterAll
	static void afterAll() {
		celsius = 0.00;
		fahrenheit = 0.00;
	}

	@Test
	void celsiusToFahrenheit() {
		assertEquals(Math.round(fahrenheit), Math.round(TemperatureConverter.celsiusToFahrenheit(celsius)));
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
				() -> TemperatureConverter.celsiusToFahrenheit(-273.16));

		assertEquals("Temperature cannot be below absolute zero (-273.15°C)", e.getMessage());
	}

	@Test
	void fahrenheitToCelsius() {
		assertEquals(Math.round(celsius), Math.round(TemperatureConverter.fahrenheitToCelsius(fahrenheit)));
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
				() -> TemperatureConverter.fahrenheitToCelsius(-459.68));

		assertEquals("Temperature cannot be below absolute zero (-459.67°F)", e.getMessage());
	}
}
