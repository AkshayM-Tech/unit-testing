package com.ak.junit.assertions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class AssertFalseTest {
    @Test
    public void assertFalseTest_01(){
        assertFalse(2 > 5);
    }
}
