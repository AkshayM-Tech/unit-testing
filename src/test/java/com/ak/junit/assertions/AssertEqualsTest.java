package com.ak.junit.assertions;

import com.ak.Calculator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AssertEqualsTest {

    // For primitive values it uses '=='
    @Test
    public void assertEqualsTest_01(){
        //Arrange
        Calculator calculator = new Calculator();

        //Act
        int actualResult = calculator.multiply(2,4);

        //Assert
        assertEquals(8, actualResult);
    }

    // For objects it uses 'equals()'
    @Test
    public void assertEqualsTest_02(){
        assertEquals("Akshay", new String("Akshay"));
        assertEquals("Avinash", "Avinash");
        assertEquals(new StringBuffer("Avinash"), new StringBuffer("Avinash"));
    }
}
