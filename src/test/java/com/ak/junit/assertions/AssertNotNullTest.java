package com.ak.junit.assertions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class AssertNotNullTest {
    @Test
    public void assertNotNullTest_01(){
        String str = "abc";
        assertNotNull(str);
    }

    @Test
    public void assertNotNullTest_02(){
        String str = null;
        assertNotNull(str);
    }
}
