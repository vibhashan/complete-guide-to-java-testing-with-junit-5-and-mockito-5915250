package com.linkedin.app;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class WeatherResponseTest {
    private static WeatherResponse weatherResponse;

    @BeforeAll
    static void beforeAll() {
        weatherResponse = new WeatherResponse(new WeatherMain(40));
    }

    @AfterAll
    static void afterAll() {
        weatherResponse = null;
    }

    @Test
    void weatherConstructor() {
        WeatherResponse weatherResponse = new WeatherResponse();

        assertNotNull(weatherResponse);
    }

    @Test
    void getMain() {
        assertNotNull(weatherResponse);
    }

    @Test
    void setTemp() {
        var oldMain = weatherResponse.getMain();
        weatherResponse.setMain(new WeatherMain());

        assertNotEquals(oldMain, weatherResponse.getMain());
    }
}
