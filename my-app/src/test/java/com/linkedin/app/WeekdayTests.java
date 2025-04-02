package com.linkedin.app;

import java.time.DayOfWeek;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;

public class WeekdayTests {

    @Test
    void weekdays() {
        System.out.println("This test runs only on weekdays.");
        // Your test logic here
    }

    @Test
    void weekends() {
        System.out.println("This test runs only on weekends.");
        // Your test logic here
    }

    // Custom method to determine if it's a weekday
    private boolean isWeekday() {
        DayOfWeek dayOfWeek = LocalDate.now().getDayOfWeek();
        return dayOfWeek != DayOfWeek.SATURDAY && dayOfWeek != DayOfWeek.SUNDAY;
    }
}