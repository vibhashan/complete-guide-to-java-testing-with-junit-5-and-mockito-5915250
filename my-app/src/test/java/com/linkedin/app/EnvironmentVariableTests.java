package com.linkedin.app;

import org.junit.jupiter.api.Test;

public class EnvironmentVariableTests {

  @Test
  void developmentEnvironment() {
    System.out.println("This test runs only in the development environment.");
    // Your test logic here
  }

  @Test
  void productionEnvironment() {
    System.out.println("This test does not run in the production environment.");
    // Your test logic here
  }
}