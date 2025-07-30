package util;

import org.example.util.StringProblems;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class StringProblemsTest {

    @Test
    public void testReverseString() {
        assertEquals("dvba", StringProblems.reverseString("abvd"));
    }

    @Test
    public void testReversePalindrome() {
        assertEquals("racecar", StringProblems.reverseString("racecar"));
    }

    @Test
    public void testReverseEmpty() {
        assertNull(StringProblems.reverseString(null));
        assertEquals("", StringProblems.reverseString(""));
    }

    @Test
    public void testReverseSmall() {
        assertEquals("1", StringProblems.reverseString("1"));
    }

    @Test
    public void testCountDuplicates() {
        String s = "hello";
        Map<Character, Integer> expected = Map.of(
                'h', 1,
                'e', 1,
                'l', 2,
                'o', 1);

        testCountDuplicatesHelper(s, expected);
    }

    private void testCountDuplicatesHelper(String s, Map<Character, Integer> expected) {
        Map<Character, Integer> actual = StringProblems.countFrequency(s);

        assertEquals(expected.size(), actual.size());
        actual.keySet().forEach(key -> {
            assertEquals(expected.get(key), actual.get(key));
        });
    }

    @Test
    public void testCountDuplicatesEmpty() {
        assertEquals(Collections.emptyMap(), StringProblems.countFrequency(null));
        assertEquals(Collections.emptyMap(), StringProblems.countFrequency(""));
    }

    @Test
    public void testCountDuplicatesAllSame() {
        String s = "     ";
        Map<Character, Integer> expected = Map.of(
                ' ', s.length());

        testCountDuplicatesHelper(s, expected);
    }

    @Test
    public void testSortList() {
        List<String> words = List.of("apple", "taco", "banana");
        List<String> expected = List.of("apple", "banana", "taco");

        assertEquals(expected, StringProblems.sortList(words));
    }

    @Test
    public void testSortListEmpty() {
        assertEquals(Collections.emptyList(), StringProblems.sortList(null));
        assertEquals(Collections.emptyList(), StringProblems.sortList(Collections.emptyList()));
    }

    @Test
    public void testSortListSmall() {
        List<String> words = List.of("apple");
        assertEquals(words, StringProblems.sortList(words));
    }

    @Test
    public void testIsPalindrome() {
        assertTrue(StringProblems.isPalindrome("tacocat"));

        assertFalse(StringProblems.isPalindrome("waluigi"));
        assertFalse(StringProblems.isPalindrome("tacocAt"));

        assertFalse(StringProblems.isPalindrome(null));

        assertTrue(StringProblems.isPalindrome(""));
        assertTrue(StringProblems.isPalindrome("a"));
    }
}
