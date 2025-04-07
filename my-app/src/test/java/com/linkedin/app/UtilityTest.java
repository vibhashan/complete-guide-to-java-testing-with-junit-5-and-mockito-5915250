package com.linkedin.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mockStatic;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.MockedStatic;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class UtilityTest {

    @Test
    void celsiusToFahrenheit() {
        try (MockedStatic<Utility> utility = mockStatic(Utility.class)) {
            utility.when(() -> Utility.celsiusToFahrenheit(0)).thenReturn(32.0);
            assertEquals(32.0, Utility.celsiusToFahrenheit(0));
        }
    }
}