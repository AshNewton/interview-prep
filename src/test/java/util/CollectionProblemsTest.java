package util;

import org.example.util.CollectionProblems;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CollectionProblemsTest {

    @Test
    public void testFindDuplicates(){
        List<String> list = List.of("a", "b", "a");
        List<String> duplicates = List.of("a");

        assertTrue(CollectionProblems.findDuplicates(list).containsAll(duplicates));
    }

    @Test
    public void testFindDuplicatesEmpty(){
        assertTrue(CollectionProblems.findDuplicates(null)
                .containsAll(Collections.emptyList()));

        assertTrue(CollectionProblems.findDuplicates(Collections.emptyList())
                .containsAll(Collections.emptyList()));
    }


    @Test
    public void testFindDuplicatesSmall(){
        List<String> list = List.of("a");
        List<String> duplicates = List.of();

        assertTrue(CollectionProblems.findDuplicates(list).containsAll(duplicates));
    }


    @Test
    public void testFindDuplicatesAllDuplicates(){
        List<String> list = List.of("a", "a", "a");
        List<String> duplicates = List.of("a");

        assertTrue(CollectionProblems.findDuplicates(list).containsAll(duplicates));
    }


    @Test
    public void testFindDuplicatesNoDuplicates(){
        List<String> list = List.of("a", "b", "c");
        List<String> duplicates = List.of();

        assertTrue(CollectionProblems.findDuplicates(list).containsAll(duplicates));
    }


    @Test
    public void testFindDuplicatesDifferentType(){
        List<Integer> list = List.of(1, 45, 1);
        List<Integer> duplicates = List.of(1);

        assertTrue(CollectionProblems.findDuplicates(list).containsAll(duplicates));
    }
}
