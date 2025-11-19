package com.ak.junit.annotations;

import com.ak.junit.Calculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Calculator Disabled Test Class")
public class CalculatorDisableTest {
    private Calculator calculator;

    @BeforeEach
    public void setUp(){
        calculator = new Calculator();
    }

    @Disabled("Disabled until ticket #720 fixed")
    @DisplayName("Calculator Addition Test")
    @Test
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
