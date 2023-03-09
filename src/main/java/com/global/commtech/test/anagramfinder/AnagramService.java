package com.global.commtech.test.anagramfinder;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AnagramService {

    List<List<String>> findAnagrams(List<String> words) {
        Map<String, List<String>> anagramMap = new HashMap<>();

        words.forEach(word -> {
            String sortedByChars = sortStringChars(word);
            List<String> anagramList = anagramMap.getOrDefault(sortedByChars, new ArrayList<>());
            anagramList.add(word);
            anagramMap.put(sortedByChars, anagramList);
        });

        return anagramMap.values().stream().toList();
    }

    private String sortStringChars(String word) {
        char[] charList = word.toLowerCase().toCharArray();
        Arrays.sort(charList);
        return String.valueOf(charList);
    }
}
