package com.global.commtech.test.anagramfinder;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class FileProcessor {

    private final AnagramService anagramService;
    private final OutputService outputService;


    void processFileByChunks(BufferedReader reader) throws IOException {
        int currentWordLength = 0;

        List<String> wordList = new ArrayList<>();
        Set<String> duplicationCheckSet = new HashSet<>();

        String line;
        while ((line = reader.readLine()) != null) {
            if (currentWordLength != line.length() && !wordList.isEmpty()) {
                findAnagramsAndPrint(wordList);

                wordList = new ArrayList<>();
                duplicationCheckSet = new HashSet<>();
            }

            if (!duplicationCheckSet.contains(line)) {
                wordList.add(line);
                duplicationCheckSet.add(line);
                currentWordLength = line.length();
            }
        }

        if (!wordList.isEmpty()) {
            findAnagramsAndPrint(wordList);
        }
    }

    private void findAnagramsAndPrint(List<String> wordList) {
        List<List<String>> anagramList = anagramService.findAnagrams(wordList);
        outputService.printAnagramList(anagramList);
    }

}
