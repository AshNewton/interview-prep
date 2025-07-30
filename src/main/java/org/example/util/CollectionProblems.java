package org.example.util;

import org.springframework.util.CollectionUtils;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CollectionProblems {

    public static <T> Collection<T> findDuplicates(List<T> list) {
        Set<T> seen = new HashSet<>();
        Set<T> duplicates = new HashSet<>();

        if (list == null) {
            return duplicates;
        }

        list.forEach(item -> {
            if (seen.contains(item)) {
                duplicates.add(item);
            } else {
                seen.add(item);
            }
        });

        return duplicates;
    }

    public static <T> int binarySearch(List<Comparable<T>> list, T element) {

        if (CollectionUtils.isEmpty(list)) {
            return -1;
        }

        int low = 0;
        int high = list.size()-1;

        while (low <= high) {
            int index = (low+high)/2;
            Comparable<T> current = list.get(index);
            if (current.equals(element)) {
                return index;
            } else if (current.compareTo(element) < 0) {
                // go up
                low = index+1;
            } else {
                // go down
                high = index-1;
            }
        }

        return -1; // not found
    }
}
