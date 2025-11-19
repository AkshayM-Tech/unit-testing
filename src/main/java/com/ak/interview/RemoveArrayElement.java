package com.ak.interview;

import java.util.Arrays;

public class RemoveArrayElement {
    public static void main(String[] args) {
        int[] input = {1,2,3,4,5,3};

        int[] result = removeElement(3, input);

        System.err.println("INPUT : "+ Arrays.toString(input));
        System.err.println("RESULT : "+ Arrays.toString(result));
    }

    private static int[] removeElement(int element, int[] input) {
        return Arrays.stream(input).boxed()
                .filter(value -> value != element)
                .mapToInt(i -> i)
                .toArray();
    }
}
