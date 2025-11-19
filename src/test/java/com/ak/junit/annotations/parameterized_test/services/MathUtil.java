package com.ak.junit.annotations.parameterized_test.services;

import com.ak.junit.annotations.parameterized_test.services.Days;

public class MathUtil {
    public boolean isEvenNumber(int number){
        return number % 2 == 0;
    }

    public boolean isOddNumber(int number){
        return number % 2 != 0;
    }

    public boolean isWeekDay(Days day){
        return day != Days.SATURDAY && day != Days.SUNDAY;
    }

    public boolean isWeekEnd(Days day){
        return day == Days.SATURDAY || day == Days.SUNDAY;
    }

    public long factorial(int number){
        int result = 1;

        for (int i = 1; i <= number; i++){
            result *= i;
        }
        return result;
    }

    public int additionOfTwoNumbers(int a, int b){
        return a + b;
    }
}
