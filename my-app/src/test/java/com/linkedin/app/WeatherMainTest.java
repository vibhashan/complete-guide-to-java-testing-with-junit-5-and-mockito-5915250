package com.linkedin.app;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class WeatherMainTest {

  private static final WeatherMain underTest = new WeatherMain(25.0);

  @Test
  public void getSetTemp() {
    assertEquals(25.0, underTest.getTemp());
    double newTemp = 30.0;
    underTest.setTemp(newTemp);
    assertEquals(newTemp, underTest.getTemp());
  }

}
