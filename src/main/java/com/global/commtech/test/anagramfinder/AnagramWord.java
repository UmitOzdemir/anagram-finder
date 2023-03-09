package com.global.commtech.test.anagramfinder;

import java.util.Arrays;

public class AnagramWord {

    private final String word;

    public AnagramWord(String word) {
        this.word = word;
    }

    public String getWord() {
        return word;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        AnagramWord that = (AnagramWord) o;

        return this.getWordSortedByChars().equals(that.getWordSortedByChars());
    }

    @Override
    public int hashCode() {
        if (word == null) {
            return 0;
        }

        return getWordSortedByChars().hashCode();
    }

    public String getWordSortedByChars() {
        char[] charList = this.word.toCharArray();
        Arrays.sort(charList);
        return String.valueOf(charList);
    }
}
