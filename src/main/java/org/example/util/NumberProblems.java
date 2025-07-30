package org.example.util;

import java.util.ArrayList;
import java.util.List;

public class NumberProblems {

    public static void swapTwoNumbersWithoutThirdVariable(int a, int b) {
        System.out.printf("a: %d, b: %d%n", a, b);
        a = a + b;
        b = a - b;
        a = a - b;
        System.out.printf("a: %d, b: %d%n", a, b);
    }

    public static long factorial(int n) {
        if (n <= 1) {
            return 1;
        }

        return n * factorial(n-1);
    }

    public static int fibonacci(int n) {
        if (n == 1) {
            return 0;
        }

        if (n == 2) {
            return 1;
        }

        return fibonacci(n-1) + fibonacci(n-2);
    }

    public static List<Integer> getFibonacciList(int n) {
        List<Integer> result = new ArrayList<>();

        for (int i=1; i<=n; i++) {
            result.add(fibonacci(i));
        }

        return result;
    }
}
