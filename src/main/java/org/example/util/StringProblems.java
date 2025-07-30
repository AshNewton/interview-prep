package org.example.util;

import io.micrometer.common.util.StringUtils;
import org.springframework.util.CollectionUtils;

import java.util.*;

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

    public static List<String> sortList(List<String> list) {
        if (CollectionUtils.isEmpty(list)) {
            return Collections.emptyList();
        }

        List<String> copy = new ArrayList<>(list);

        copy.sort(Comparator.naturalOrder());

        return copy;
    }

    public static boolean isPalindrome(String s) {
        return s != null && s.equals(reverseString(s));
    }

    public static final List<Character> VOWELS = List.of('a', 'e', 'i', 'o', 'u');
    public static int countVowels(String s) {
        int count = 0;

        if(StringUtils.isBlank(s)) {
            return count;
        }

        for(char c: s.toCharArray()) {
            if (VOWELS.contains(c)) {
                count++;
            }
        }

        return count;
    }
}
