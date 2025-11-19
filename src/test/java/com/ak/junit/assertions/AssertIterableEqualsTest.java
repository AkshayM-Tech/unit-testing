package com.ak.junit.assertions;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

public class AssertIterableEqualsTest {
    @Test
    public void assertIterableEqualsTest_01(){
        List<Integer> list1 = List.of(1,2,3,4,5);
        List<Integer> list2 = List.of(1,2,3,4,5);

        assertIterableEquals(list1, list2);
    }

    @Test
    public void assertIterableEqualsTest_02(){
        Set<Integer> set1 = Set.of(1,2,3,4,5);
        Set<Integer> set2 = Set.of(1,2,3,4,5);

        assertIterableEquals(set1, set2);
    }

    @Test
    public void assertIterableEqualsTest_03(){
        List<Integer> list1 = List.of(1,2,3,4,5);
        List<Integer> list2 = List.of(1,3,2,5,4);

        assertIterableEquals(list1, list2);
    }
}
