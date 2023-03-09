package com.global.commtech.test.anagramfinder;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AnagramWordTest {

    @Test
    void equalsShouldReturnTrueWhenObjectsSame() {
        AnagramWord word = new AnagramWord("abcd");

        assertTrue(word.equals(word));
    }

    @Test
    void equalsShouldReturnFalseWhenComparingWithDifferentObjectOrNull() {
        AnagramWord anagramWord = new AnagramWord("abcd");
        String stringWord = "abcd";

        assertFalse(anagramWord.equals(null));
        assertFalse(anagramWord.equals(stringWord));
    }

    @Test
    void hashCodeShouldReturnZeroWhenNull() {
        AnagramWord word = new AnagramWord(null);

        assertEquals(0, word.hashCode());
    }

    @Test
    void hashCodeShouldReturnSameValuesForEqualStrings() {
        AnagramWord word1 = new AnagramWord("abcd");
        AnagramWord word2 = new AnagramWord("abcd");

        assertTrue(word1.equals(word2));
        assertEquals(word1.hashCode(), word2.hashCode());
    }

    @Test
    void hashCodeShouldReturnDifferentHashValuesForNotAnagrams() {
        AnagramWord word1 = new AnagramWord("abcd");
        AnagramWord word2 = new AnagramWord("efgh");

        assertFalse(word1.equals(word2));
        assertNotEquals(word1.hashCode(), word2.hashCode());
    }

    @Test
    void hashCodeShouldReturnSameHashValuesForAnagramsButNotEquals() {
        AnagramWord word1 = new AnagramWord("ab");
        AnagramWord word2 = new AnagramWord("ba");

        assertFalse(word1.getWord().equals(word2.getWord()));
        assertEquals(word1.hashCode(), word2.hashCode());
    }
}