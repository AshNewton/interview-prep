package org.example.util;

import io.micrometer.common.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

public class StringProblems {

    public static String reverseString(String s) {
        if (s == null) {
            return null;
        }

        return new StringBuffer(s).reverse().toString();
    }

    public static Map<Character, Integer> countFrequency(String s) {
        Map<Character, Integer> histogram = new HashMap<>();

        if (StringUtils.isEmpty(s)) {
            return histogram;
        }

        for (int i=0; i<s.length(); i++) {
            Character c = s.charAt(i);
            Integer newCount = histogram.getOrDefault(c, 0);

            histogram.put(c, newCount+1);
        }

        return histogram;
    }
}
