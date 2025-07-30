package util;

import org.example.util.StringProblems;
import org.junit.jupiter.api.Test;

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
}
