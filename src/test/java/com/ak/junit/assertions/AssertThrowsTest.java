package com.ak.junit.assertions;

import com.ak.Calculator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class AssertThrowsTest {

    private static Calculator calculator;

    @BeforeAll
    public static void setUp(){
        calculator = new Calculator();
    }

    @Test
    public void assertThrowsTest_01(){
        assertThrows(Exception.class, () -> Integer.parseInt("abc"));
    }

    @Test
    public void assertThrowsTest_02(){
        assertThrows(NumberFormatException.class, () -> Integer.parseInt("abc"));
    }

    @Test
    public void assertThrowsTest_03(){
        assertThrows(ArithmeticException.class, () -> Integer.parseInt("abc"));
    }

    @Test
    public void assertThrowsTest_04(){
        assertThrows(Exception.class, () -> calculator.divide(4, 0));
    }
}
