package util;

import org.example.util.StringProblems;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

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
}
