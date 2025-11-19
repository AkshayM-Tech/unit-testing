package com.ak.junit.annotations;

import com.ak.junit.Calculator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorNestedTest {
    private Calculator calculator;

    @BeforeEach
    public void setUp(){
        calculator = new Calculator();
        System.out.println("CalculatorNestedTest BeforeEach setUp()...");
    }

    @Nested
    class AddNested{
        @BeforeEach
        public void setUp(){
            System.out.println("AddNested @BeforeEach setUp()...");
        }

        @AfterEach
        public void tearDown(){
            System.out.println("AddNested @AfterEach tearDown()...");
        }

        @Test
        public void testAddPositiveNumbers(){
            assertEquals(7, calculator.add(3, 4));
        }

        @Test
        public void testAddPositiveAndNegativeNumbers(){
            assertEquals(1, calculator.add(4, -3));
        }

        @Test
        public void testAddNegativeNumbers(){
            assertEquals(-7, calculator.add(-3, -4));
        }
    }

    @Nested
    class SubtractionNested{
        @BeforeEach
        public void setUp(){
            System.out.println("SubtractionNested @BeforeEach setUp()...");
        }

        @AfterEach
        public void tearDown(){
            System.out.println("SubtractionNested @AfterEach tearDown()...");
        }

        @Test
        public void testSubtractPositiveNumbers(){
            assertEquals(1, calculator.subtract(4, 3));
        }

        @Test
        public void testSubtractLargerFromSmaller(){
            assertEquals(-4, calculator.subtract(3, 7));
        }
    }
}
