package util;

import org.example.util.CollectionProblems;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

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

    @Test
    public void testBinarySearch(){
        List<Comparable<Character>> test1 = List.of('a', 'b', 'c', 'd', 'e');
        assertEquals(3, CollectionProblems.binarySearch(test1, 'd'));
    }

    @Test
    public void testBinarySearchNotFound(){
        List<Comparable<Character>> test1 = List.of('a', 'b', 'c', 'd', 'e');
        assertEquals(-1, CollectionProblems.binarySearch(
                test1,
                'q'));
    }

    @Test
    public void testBinarySearchFirst(){
        List<Comparable<Character>> test1 = List.of('a', 'b', 'c', 'd', 'e');

        assertEquals(0, CollectionProblems.binarySearch(
                test1,
                'a'));
    }

    @Test
    public void testBinarySearchLast(){

        List<Comparable<Character>> test1 = List.of('a', 'b', 'c', 'd', 'e');

        assertEquals(4, CollectionProblems.binarySearch(
                test1,
                'e'));
    }

    @Test
    public void testBinarySearchEmpty(){
        assertEquals(-1, CollectionProblems.binarySearch(
                Collections.emptyList(),
                'a'));
        assertEquals(-1, CollectionProblems.binarySearch(
                null,
                'a'));
    }

    @Test
    public void testBinarySearchSmall(){
        assertEquals(0, CollectionProblems.binarySearch(
                List.of('a'),
                'a'));
    }

    @Test
    public void testBinarySearchNotFoundSmall(){
        List<Comparable<Character>> test1 = List.of('a', 'b', 'c', 'd', 'e');
        assertEquals(3, CollectionProblems.binarySearch(test1, 'd'));


        assertEquals(-1, CollectionProblems.binarySearch(
                List.of('a'),
                'q'));
    }

    @Test
    public void testMergeLists() {
        List<Integer> l1 = List.of(1,2,4,5,8,9);
        List<Integer> l2 = List.of(3,6,7);

        assertEquals(List.of(1,2,3,4,5,6,7,8,9), CollectionProblems.mergeLists(l1, l2));
    }

    @Test
    public void testMergeListsEmpty() {
        List<Integer> l1 = List.of();
        List<Integer> l2 = List.of();

        assertEquals(Collections.emptyList(), CollectionProblems.mergeLists(l1, l2));
    }

    @Test
    public void testMergeListsLeftEmpty() {
        List<Integer> l1 = List.of();
        List<Integer> l2 = List.of(1,2);

        assertEquals(l2, CollectionProblems.mergeLists(l1, l2));
    }

    @Test
    public void testMergeListsRightEmpty() {
        List<Integer> l1 = List.of(4,8);
        List<Integer> l2 = List.of();

        assertEquals(l1, CollectionProblems.mergeLists(l1, l2));
    }

    @Test
    public void testMergeListsDuplicates() {
        List<Integer> l1 = List.of(2);
        List<Integer> l2 = List.of(2);

        assertEquals(List.of(2, 2), CollectionProblems.mergeLists(l1, l2));
    }

    @Test
    public void testMergeListsEqualSize() {
        List<Integer> l1 = List.of(1,2,3);
        List<Integer> l2 = List.of(7,8,9);

        assertEquals(List.of(1,2,3,7,8,9), CollectionProblems.mergeLists(l1, l2));
    }

    @Test
    public void testMapToList() {
        Map<Integer, Integer> map = Map.of(1,2,3,4,5,6);
        List<Map.Entry<Integer, Integer>> expected = List.of(
                Map.entry(1,2), Map.entry(3,4), Map.entry(5,6)
        );

        List<Map.Entry<Integer, Integer>> actual = CollectionProblems.mapToList(map);

        assertEquals(expected.size(), actual.size());
        for(Map.Entry<Integer, Integer> e: expected) {
            actual.contains(e);
        }
    }

    @Test
    public void testMapToListEmpty() {
        Map<Integer, Integer> map = Map.of();
        List<Map.Entry<Integer, Integer>> expected = List.of();

        assertEquals(expected, CollectionProblems.mapToList(map));
    }

    @Test
    public void testFindSecondBiggest() {
        List<Integer> list = List.of(3,4,5,6,7,2,4);
        int expected = 6;

        assertEquals(expected, CollectionProblems.findSecondHighest(list));
    }

    @Test
    public void testFindSecondBiggestFirst() {
        List<Integer> list = List.of(6,3,4,5,7,2,4);
        int expected = 6;

        assertEquals(expected, CollectionProblems.findSecondHighest(list));
    }

    @Test
    public void testFindSecondBiggestLast() {
        List<Integer> list = List.of(3,4,5,7,2,4,6);
        int expected = 6;

        assertEquals(expected, CollectionProblems.findSecondHighest(list));
    }

    @Test
    public void testFindSecondBiggestSmall() {
        List<Integer> list = List.of(3,4);
        int expected = 3;

        assertEquals(expected, CollectionProblems.findSecondHighest(list));
    }

    @Test
    public void testFindSecondBiggestSmall2() {
        List<Integer> list = List.of(4,3);
        int expected = 3;

        assertEquals(expected, CollectionProblems.findSecondHighest(list));
    }

    @Test
    public void testFindSecondBiggestTooSmall() {

        try {
            CollectionProblems.findSecondHighest(Collections.emptyList());
            fail(); // fail if error not thrown
        } catch (RuntimeException ignored) {}

        try {
            CollectionProblems.findSecondHighest(List.of(1));
            fail(); // fail if error not thrown
        } catch (RuntimeException ignored) {}
    }

    @Test
    public void testRemoveDuplicates(){
        assertEquals(Collections.emptyList(),
                CollectionProblems.removeDuplicates(null));

        assertEquals(Collections.emptyList(),
                CollectionProblems.removeDuplicates(
                        Collections.emptyList()));

        assertEquals(List.of(1),
                CollectionProblems.removeDuplicates(
                        List.of(1)));

        assertEquals(List.of(1),
                CollectionProblems.removeDuplicates(
                        List.of(1, 1)));

        assertEquals(List.of(1,2,3,4),
                CollectionProblems.removeDuplicates(
                        List.of(1,2,3,4)));
    }
}
