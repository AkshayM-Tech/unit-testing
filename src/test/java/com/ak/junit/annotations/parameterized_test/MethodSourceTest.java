package com.ak.junit.annotations.parameterized_test;

import com.ak.junit.annotations.parameterized_test.services.MathUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MethodSourceTest {

    private MathUtil mathUtil;

    @BeforeEach
    public void setUp(){
        mathUtil = new MathUtil();
    }

    @ParameterizedTest
    @MethodSource(value = "argumentProvider")
    public void factorialTest(int number, int expected){
        assertEquals(expected, mathUtil.factorial(number));
    }

    public static Stream<Arguments> argumentProvider(){
        return Stream.of(
                Arguments.arguments(0, 1),
                Arguments.arguments(1, 1),
                Arguments.arguments(2, 2),
                Arguments.arguments(3, 6),
                Arguments.arguments(4, 24),
                Arguments.arguments(5, 120)
        );
    }
}
