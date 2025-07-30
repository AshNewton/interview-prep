package util;

import org.example.util.NumberProblems;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NumberProblemsTest {

    @Test
    public void testFactorial() {
        assertEquals(1, NumberProblems.factorial(-42));
        assertEquals(1, NumberProblems.factorial(0));
        assertEquals(1, NumberProblems.factorial(1));

        assertEquals(2, NumberProblems.factorial(2));
        assertEquals(6, NumberProblems.factorial(3));
        assertEquals(24, NumberProblems.factorial(4));
        assertEquals(120, NumberProblems.factorial(5));
    }

    @Test
    public void testFibonacciList() {
        assertEquals(List.of(0), NumberProblems.getFibonacciList(1));
        assertEquals(List.of(0, 1), NumberProblems.getFibonacciList(2));
        assertEquals(List.of(0, 1, 1), NumberProblems.getFibonacciList(3));
        assertEquals(List.of(0, 1, 1, 2), NumberProblems.getFibonacciList(4));
        assertEquals(List.of(0, 1, 1, 2, 3), NumberProblems.getFibonacciList(5));
        assertEquals(List.of(0, 1, 1, 2, 3, 5), NumberProblems.getFibonacciList(6));
        assertEquals(List.of(0, 1, 1, 2, 3, 5, 8), NumberProblems.getFibonacciList(7));
        assertEquals(List.of(0, 1, 1, 2, 3, 5, 8, 13), NumberProblems.getFibonacciList(8));
    }
}
