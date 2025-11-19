package com.ak.junit.annotations;

import com.ak.junit.Calculator;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Calculator Repeated Test Class")
public class CalculatorRepeatedTest {
    private Calculator calculator;

    @BeforeEach
    public void setUp(){
        calculator = new Calculator();
    }

    @RepeatedTest(5)
    @DisplayName("Calculator Addition Test")
    public void addTest(){
        int actual = calculator.add(2, 2);

        assertEquals(4, actual);
    }

    @DisplayName("Calculator Subtraction Test")
    @Test
    public void subtractTest(){
        int actual = calculator.subtract(2, 2);

        assertEquals(0, actual);
    }

    @DisplayName("Calculator Multiplication Test")
    @Test
    public void multiplyTest(){
        int actual = calculator.multiply(2, 2);

        assertEquals(4, actual);
    }

    @DisplayName("Calculator Division Test")
    @Test
    public void divideTest(){
        int actual = calculator.divide(2, 2);

        assertEquals(1, actual);
    }
}
