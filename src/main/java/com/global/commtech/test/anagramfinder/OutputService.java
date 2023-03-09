package com.global.commtech.test.anagramfinder;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OutputService {
    public void printAnagramList(List<List<String>> anagramList) {
        anagramList.forEach(word -> System.out.println(String.join(",", word)));
    }
}
