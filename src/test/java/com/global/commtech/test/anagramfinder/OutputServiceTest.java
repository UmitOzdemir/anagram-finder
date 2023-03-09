package com.global.commtech.test.anagramfinder;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.system.CapturedOutput;
import org.springframework.boot.test.system.OutputCaptureExtension;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(OutputCaptureExtension.class)
class OutputServiceTest {

    private final OutputService outputService = new OutputService();

    @Test
    void shouldPrintoutList(final CapturedOutput capturedOutput) {
        List<List<String>> anagramList1 = List.of(Arrays.asList("abc", "cba"), List.of("ddd"));
        outputService.printAnagramList(anagramList1);
        assertThat(capturedOutput.getOut()).contains("abc,cba");
        assertThat(capturedOutput.getOut()).contains("ddd");
    }
}