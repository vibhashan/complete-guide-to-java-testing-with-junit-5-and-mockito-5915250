package com.linkedin.app;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class WeatherResponseTest {
  
  private static final WeatherMain WEATHER_MAIN = new WeatherMain(25.0);
  private static final WeatherResponse underTest = new WeatherResponse(WEATHER_MAIN);

  @Test
  public void getWeatherMain() {
    assertEquals(WEATHER_MAIN, underTest.getMain());
  }
}
