package com.global.commtech.test.anagramfinder;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class FileProcessorTest {

    @Mock
    private AnagramService anagramService;

    @Mock
    private OutputService outputService;

    @Mock
    private BufferedReader reader;

    @InjectMocks
    private FileProcessor fileProcessor;

    @Test
    void processFileShouldFindAnagramsAndPublish() throws IOException {
        when(reader.readLine())
                .thenReturn("abc")
                .thenReturn("cba")
                .thenReturn("ddd")
                .thenReturn("abcd")
                .thenReturn(null);

        List<AnagramWord> chunk1 = List.of(new AnagramWord("abc"), new AnagramWord("cba"), new AnagramWord("ddd"));
        List<AnagramWord> chunk2 = List.of(new AnagramWord("abcd"));

        List<List<String>> anagramList1 = List.of(Arrays.asList("abc", "cba"), List.of("ddd"));
        List<List<String>> anagramList2 = List.of(List.of("abcd"));


        when(anagramService.findAnagrams(chunk1)).thenReturn(anagramList1);
        when(anagramService.findAnagrams(chunk2)).thenReturn(anagramList2);

        fileProcessor.readFileByChunks(reader);

        verify(outputService).printAnagramList(anagramList1);
        verify(outputService).printAnagramList(anagramList2);
    }

    @Test
    void processFileShouldRemoveDuplicates() throws IOException {
        when(reader.readLine())
                .thenReturn("abc")
                .thenReturn("abc")
                .thenReturn("abc")
                .thenReturn(null);

        List<AnagramWord> chunk = List.of(new AnagramWord("abc"));
        List<List<String>> anagramList = List.of(List.of("abc"));

        when(anagramService.findAnagrams(chunk)).thenReturn(anagramList);

        fileProcessor.readFileByChunks(reader);

        verify(outputService).printAnagramList(anagramList);
    }


    @Test
    void processFileShouldFindAnagramWhenFileIsEmpty() throws IOException {
        when(reader.readLine()).thenReturn(null);

        fileProcessor.readFileByChunks(reader);

        verifyNoInteractions(anagramService);
        verifyNoInteractions(outputService);
    }
}