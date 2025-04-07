package com.linkedin.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class WeatherMainTest {
    private static WeatherMain weatherMain;

    @BeforeAll
    static void beforeAll() {
        weatherMain = new WeatherMain(23);
    }

    @AfterAll
    static void afterAll() {
        weatherMain = null;
    }

    @Test
    void weatherConstructor() {
        WeatherMain weatherMain = new WeatherMain();

        assertNotNull(weatherMain);
    }

    @Test
    void getTemp() {
        assertNotNull(weatherMain);
        assertEquals(23.0, weatherMain.getTemp());
    }

    @Test
    void setTemp() {
        weatherMain.setTemp(40);
        assertEquals(40.0, weatherMain.getTemp());
    }
}
