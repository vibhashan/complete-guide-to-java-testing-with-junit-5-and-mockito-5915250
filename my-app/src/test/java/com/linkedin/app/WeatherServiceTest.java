package com.linkedin.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@ExtendWith(MockitoExtension.class)
public class WeatherServiceTest {

  @InjectMocks
  private WeatherService underTest;

  @Mock
  private RestTemplate restTemplate;

  private static final String CITY = "London";
  private static final double TEMP = 72;
  private static final String API_KEY = "123456";

  @BeforeEach
  public void setUp() {
    ReflectionTestUtils.setField(underTest, "apiKey", API_KEY);
  }

  @Test
  public void getWeather() {
    WeatherResponse mockResponse = new WeatherResponse(new WeatherMain(TEMP));
    when(restTemplate.getForObject("https://api.openweathermap.org/data/2.5/weather?q="
        + CITY + "&appid=" + API_KEY + "&units=imperial",
        WeatherResponse.class)).thenReturn(mockResponse);
    WeatherResponse response = underTest.getWeather(CITY);
    assertEquals(mockResponse, response);
  }

  @Test
  public void getWeather_apiError() {
    when(restTemplate.getForObject("https://api.openweathermap.org/data/2.5/weather?q="
        + CITY + "&appid=" + API_KEY + "&units=imperial",
        WeatherResponse.class))
        .thenThrow(new RestClientException("Error occurred"));

    Exception e = assertThrows(RestClientException.class, () -> {
      underTest.getWeather(CITY);
    });
    assertEquals(e.getMessage(), "Error occurred");

  }
}
