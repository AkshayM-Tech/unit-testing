package com.ak.junit.assertions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertSame;

public class AssertNotSameTest {
    @Test
    public void assertNotSameTest_01(){
        assertNotSame("Junit", "Junit");
    }

    @Test
    public void assertNotSameTest_02(){
        assertNotSame(new String("Junit"), new String("Junit"));
    }
}
