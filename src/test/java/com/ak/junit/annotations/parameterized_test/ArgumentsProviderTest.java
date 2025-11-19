package com.ak.junit.annotations.parameterized_test;

import com.ak.junit.annotations.parameterized_test.services.FactorialArgumentsProvider;
import com.ak.junit.annotations.parameterized_test.services.MathUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArgumentsProviderTest {

    private MathUtil mathUtil;

    @BeforeEach
    public void setUp(){
        mathUtil = new MathUtil();
    }

    @ParameterizedTest
    @ArgumentsSource(FactorialArgumentsProvider.class)
    public void factorialTest(int number, int expected){
        assertEquals(expected, mathUtil.factorial(number));
    }
}
