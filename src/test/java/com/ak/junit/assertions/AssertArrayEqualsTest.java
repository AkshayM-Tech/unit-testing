package com.ak.junit.assertions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class AssertArrayEqualsTest {
    @Test
    public void assertArrayEqualsTest_01(){
        int[] array1 = {1,2,3,4,5};
        int[] array2 = {1,2,3,4,5};

        assertArrayEquals(array1, array2);
    }

    @Test
    public void assertArrayEqualsTest_02(){
        String[] array1 = {"Akshay", "Priya", "Avinash"};
        String[] array2 = {new String("Akshay"), new String("Priya"), new String("Avinash")};

        assertArrayEquals(array1, array2);
    }

    @Test
    public void assertArrayEqualsTest_03(){
        int[] array1 = {1,2,3,4,5};
        int[] array2 = {1,3,2,5,4};

        assertArrayEquals(array1, array2);
    }
}
