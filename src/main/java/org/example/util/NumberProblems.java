package org.example.util;

public class NumberProblems {

    public static void swapTwoNumbersWithoutThirdVariable(int a, int b) {
        System.out.printf("a: %d, b: %d%n", a, b);
        a = a + b;
        b = a - b;
        a = a - b;
        System.out.printf("a: %d, b: %d%n", a, b);
    }

}
