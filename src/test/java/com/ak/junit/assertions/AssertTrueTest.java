package com.ak.junit.assertions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class AssertTrueTest {
    @Test
    public void assertTrueTest_01(){
        assertTrue(5 > 2);
    }
}
