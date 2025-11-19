package com.ak.junit.assertions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNull;

public class AssertNullTest {
    @Test
    public void assertNullTest_01(){
        String str = null;
        assertNull(str);
    }

    @Test
    public void assertNullTest_02(){
        String str = "abc";
        assertNull(str);
    }
}
