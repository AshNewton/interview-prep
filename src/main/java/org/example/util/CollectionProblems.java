package org.example.util;

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
}
