package com.ak.junit.assertions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertSame;

public class AssertSameTest {
    @Test
    public void assertSameTest_01(){
        assertSame("Junit", "Junit");
    }

    @Test
    public void assertSameTest_02() {
        assertSame(new String("Junit"), new String("Junit"));
    }
}
