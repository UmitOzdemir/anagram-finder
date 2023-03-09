package com.global.commtech.test.anagramfinder;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class AnagramServiceTest {

    private final AnagramService anagramService = new AnagramService();


    @Test
    void findAnagramsShouldReturnEmptyListWhenNoWords() {
        var result = anagramService.findAnagrams(Collections.emptyList());

        assertThat(result).isEmpty();
    }

    @Test
    void findAnagramsShouldReturnAnagramListWhenNoWords() {
        List<String> chunk = List.of("abc", "cba", "ddd");
        var result = anagramService.findAnagrams(chunk);

        assertThat(result).isNotNull().isNotEmpty().hasSize(2);
        assertThat(result.get(0)).isNotNull().isNotEmpty().hasSize(2).contains("abc", "cba");
        assertThat(result.get(1)).isNotNull().isNotEmpty().hasSize(1).contains("ddd");
    }

    @Test
    void findAnagramsShouldProcessUpperCaseAsADifferentWord() {
        List<String> chunk = List.of("abc", "cba", "ABC");
        var result = anagramService.findAnagrams(chunk);

        assertThat(result).isNotNull().isNotEmpty().hasSize(1);
        assertThat(result.get(0)).isNotNull().isNotEmpty()
                .hasSize(3).contains("abc", "cba", "ABC");
    }

}