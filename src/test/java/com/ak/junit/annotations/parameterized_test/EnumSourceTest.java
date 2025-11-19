package com.ak.junit.annotations.parameterized_test;

import com.ak.junit.annotations.parameterized_test.services.Days;
import com.ak.junit.annotations.parameterized_test.services.MathUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class EnumSourceTest {

    private MathUtil mathUtil;

    @BeforeEach
    public void setUp(){
        mathUtil = new MathUtil();
    }

    @ParameterizedTest
    @EnumSource(value = Days.class, names = {"MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY", "FRIDAY"})
    public void isWeekDayTest(Days day){
        assertTrue(mathUtil.isWeekDay(day));
    }

    @ParameterizedTest
    @EnumSource(value = Days.class, names = {"SATURDAY", "SUNDAY"})
    public void isWeekEndTest(Days day){
        assertTrue(mathUtil.isWeekEnd(day));
    }
}
