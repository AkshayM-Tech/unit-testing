package com.ak.junit.assertions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;

public class AssertInstanceOfTest {
    @Test
    public void AssertInstanceOfTest_01(){
        Number number = Integer.valueOf(10);
        assertInstanceOf(Integer.class, number);
        assertInstanceOf(Number.class, number);
    }

    @Test
    public void AssertInstanceOfTest_02(){
        String str = "Junit";
        assertInstanceOf(String.class, str);
    }

    @Test
    public void AssertInstanceOfTest_03(){
        String str = "Junit";
        assertInstanceOf(StringBuffer.class, str);
    }
}
