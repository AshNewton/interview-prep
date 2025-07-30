package org.example.util;

import org.springframework.util.CollectionUtils;

import java.util.*;

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

    public static List<Integer> mergeLists(List<Integer> list1, List<Integer> list2) {
        if (CollectionUtils.isEmpty(list1) && CollectionUtils.isEmpty(list2)) {
            return Collections.emptyList();
        } else if (CollectionUtils.isEmpty(list1)) {
            return list2;
        } else if (CollectionUtils.isEmpty(list2)) {
            return list1;
        }

        int totalSize = list1.size() + list2.size();
        List<Integer> result = new ArrayList<>(totalSize);

        int index1 = 0, index2 = 0;

        while (index1 < list1.size() && index2 < list2.size()) {
            if (list1.get(index1) < list2.get(index2)) {
                result.add(list1.get(index1));
                index1++;
            } else {
                result.add(list2.get(index2));
                index2++;
            }
        }

        if (index1 < list1.size()) {
            while (index1 < list1.size()) {
                result.add(list1.get(index1));
                index1++;
            }
        } else if (index2 < list2.size()) {
            while (index2 < list2.size()) {
                result.add(list2.get(index2));
                index2++;
            }
        }

        return result;
    }

    public static <K, V> List<Map.Entry<K, V>> mapToList(Map<K, V> map) {
        return map.entrySet().stream().toList();
    }

    public static Integer findSecondHighest(List<Integer> list) {
        if (list == null || list.size() < 2) {
            throw new RuntimeException("need at least 2 elements to find second biggest item");
        }

        int biggest = Integer.MIN_VALUE;
        int secondBiggest = Integer.MIN_VALUE;
        for(Integer i : list) {
            if (i > biggest) {
                secondBiggest = biggest;
                biggest = i;
            } else if (i > secondBiggest) {
                secondBiggest = i;
            }
        }

        return secondBiggest;
    }
}
