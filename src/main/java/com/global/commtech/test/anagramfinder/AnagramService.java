package com.global.commtech.test.anagramfinder;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AnagramService {

    List<List<String>> findAnagrams(List<AnagramWord> words) {
        Map<AnagramWord, List<String>> anagramMap = new HashMap<>();

        words.forEach(word -> {
            List<String> anagramList = anagramMap.getOrDefault(word, new ArrayList<>());
            anagramList.add(word.getWord());
            anagramMap.put(word, anagramList);
        });

        return anagramMap.values().stream().toList();
    }
}
