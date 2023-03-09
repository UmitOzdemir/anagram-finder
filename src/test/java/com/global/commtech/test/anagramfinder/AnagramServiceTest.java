package com.global.commtech.test.anagramfinder;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class AnagramServiceTest {

    private final AnagramService anagramService = new AnagramService();


    @Test
    void findAnagramsShouldReturnEmptyListWhenWordListEmpty() {
        var result = anagramService.findAnagrams(Collections.emptyList());

        assertThat(result).isEmpty();
    }

    @Test
    void findAnagramsShouldReturnAnagramListWhenWordsAreAnagram() {
        AnagramWord word1 = new AnagramWord("abc");
        AnagramWord word2 = new AnagramWord("cba");
        AnagramWord word3 = new AnagramWord("bca");

        List<AnagramWord> chunk = List.of(word1, word2, word3);

        var result = anagramService.findAnagrams(chunk);

        assertThat(result).isNotNull().isNotEmpty().hasSize(1);
        assertThat(result.get(0)).hasSize(3);
        assertThat(result.get(0).get(0)).isEqualTo(word1.getWord());
        assertThat(result.get(0).get(1)).isEqualTo(word2.getWord());
        assertThat(result.get(0).get(2)).isEqualTo(word3.getWord());
    }

    @Test
    void findAnagramsShouldReturnAnagramListWhenWordsAreNotAnagram() {
        AnagramWord word1 = new AnagramWord("abc");
        AnagramWord word2 = new AnagramWord("dfg");
        AnagramWord word3 = new AnagramWord("ABC");

        List<AnagramWord> chunk = List.of(word1, word2, word3);
        var result = anagramService.findAnagrams(chunk);

        assertThat(result).isNotNull().hasSize(3);
        assertThat(result).contains(List.of(word1.getWord()));
        assertThat(result).contains(List.of(word2.getWord()));
        assertThat(result).contains(List.of(word3.getWord()));
    }

}