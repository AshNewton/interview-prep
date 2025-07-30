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
}
