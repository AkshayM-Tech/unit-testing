package com.ak.junit.assertions;

import com.ak.Calculator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class AssertNotEqualsTest {
    @Test
    public void assertNotEqualsTest_01(){
        Calculator calculator = new Calculator();
        int actualResult = calculator.multiply(3,6);
        assertNotEquals(12, actualResult);
    }

    @Test
    public void assertNotEqualsTest_02(){
        assertNotEquals("Akshay", "Avinash");
        assertNotEquals(new StringBuffer("Akshay"), new StringBuffer("Akshay"));
    }
}
