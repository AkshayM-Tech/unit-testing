package com.ak.junit.assertions;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertLinesMatch;

public class AssertLinesMatchTest {
    @Test
    public void assertLinesMatchTest_01(){
        List<String> list1 = List.of("Akshay", "Priya", "Arnav", "Avinash");
        List<String> list2 = List.of("Akshay", "Priya", "Arnav", "Avinash");

        assertLinesMatch(list1, list2);
    }

    @Test
    public void assertLinesMatchTest_02(){
        List<String> list1 = List.of("Akshay", "Hello World From [a-zA-Z]+");
        List<String> list2 = List.of("Akshay", "Hello World From Akshay");

        assertLinesMatch(list1, list2);
    }

    @Test
    public void assertLinesMatchTest_03(){
        List<String> list1 = List.of("Akshay", "Hello World From [0-9]+");
        List<String> list2 = List.of("Akshay", "Hello World From 123");

        assertLinesMatch(list1, list2);
    }

    @Test
    public void assertLinesMatchTest_04(){
        List<String> list1 = List.of("Akshay", "Hello World From [0-9]+");
        List<String> list2 = List.of("Akshay", "Hello World From 0001");

        assertLinesMatch(list1, list2);
    }
}
