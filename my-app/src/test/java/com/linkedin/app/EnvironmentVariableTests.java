package com.linkedin.app;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledIfEnvironmentVariable;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;

public class EnvironmentVariableTests {

	@Test
	@EnabledIfEnvironmentVariable(named = "ENVIRONMENT", matches = "development")
	void developmentEnvironment() {
		System.out.println("This test runs only in the development environment.");
		// Your test logic here
	}

	@Test
	@DisabledIfEnvironmentVariable(named = "ENVIRONMENT", matches = "development")
	void productionEnvironment() {
		System.out.println("This test does not run in the production environment.");
		// Your test logic here
	}
}