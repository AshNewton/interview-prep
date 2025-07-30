package org.example.util;

public class StringProblems {

    public static String reverseString(String s) {
        if (s == null) {
            return null;
        }

        return new StringBuffer(s).reverse().toString();
    }
}
