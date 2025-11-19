package com.ak.junit.annotations.parameterized_test;

import com.ak.junit.annotations.parameterized_test.services.MathUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CsvFileSourceTest {

    private MathUtil mathUtil;

    @BeforeEach
    public void setUp(){
        mathUtil = new MathUtil();
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/factorial_data.csv")
    public void additionOfTwoNumbersTest(int num01, int num02, int expected){
        assertEquals(expected, mathUtil.additionOfTwoNumbers(num01, num02));
    }
}
