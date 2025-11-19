package com.ak.junit.annotations.parameterized_test;

import com.ak.junit.annotations.parameterized_test.services.MathUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ValueSourceMathTest {
    private MathUtil mathUtil;

    @BeforeEach
    public void setUp(){
        mathUtil = new MathUtil();
    }

    @ParameterizedTest
    @ValueSource(ints = {2,4,6,8,10})
    public void isEvenTest01(int number){
        assertTrue(mathUtil.isEvenNumber(number));
        assertFalse(mathUtil.isOddNumber(number));
    }

    @ParameterizedTest
    @ValueSource(ints = {1,3,5,7,9})
    public void isOddTest(int number){
        assertTrue(mathUtil.isOddNumber(number));
        assertFalse(mathUtil.isEvenNumber(number));
    }

    @ParameterizedTest
    @ValueSource(ints = {2,4,7,8,10})
    public void isEvenTest02(int number){
        assertTrue(mathUtil.isEvenNumber(number));
    }

    /*@ParameterizedTest
    @ValueSource(ints = {{1,2,3,4,5}, {1,2,3,4,5}})
    public void test(int a, int b){
        System.out.println(a+" : "+b);
    }*/
}
