package com.linkedin.app;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class CalculatorTest {
    @Test
    void add() {
        assertEquals(5, Calculator.add(2, 3));
        assertEquals(0, Calculator.add(0, 0));
        assertEquals(-8, Calculator.add(-5, -3));
        assertEquals(-3, Calculator.add(-5, 2));
    }
}
