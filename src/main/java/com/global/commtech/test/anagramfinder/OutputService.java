package com.global.commtech.test.anagramfinder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OutputService {
    public void printAnagramList(List<List<String>> anagramList) {
        Logger logger = LoggerFactory.getLogger(OutputService.class);
        anagramList.forEach(word -> logger.info(String.join(",", word)));
    }
}
