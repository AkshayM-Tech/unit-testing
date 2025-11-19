package com.junit.practice;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FactorialTest {

    @Test
    public void testFactorialOfZero() {
        Factorial factorial = new Factorial();
        assertEquals(1, factorial.factorial(0), "Factorial of 0 should be 1");
    }

    @Test
    public void testFactorialOfOne() {
        Factorial factorial = new Factorial();
        assertEquals(1, factorial.factorial(1), "Factorial of 1 should be 1");
    }

    @Test
    public void testFactorialOfPositiveNumber() {
        Factorial factorial = new Factorial();
        assertEquals(120, factorial.factorial(5), "Factorial of 5 should be 120");
        assertEquals(720, factorial.factorial(6), "Factorial of 6 should be 720");
    }

    @Test
    public void testFactorialOfNegativeNumber() {
        Factorial factorial = new Factorial();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            factorial.factorial(-1);
        });
        assertEquals("Negative numbers are not allowed", exception.getMessage());
    }
}
