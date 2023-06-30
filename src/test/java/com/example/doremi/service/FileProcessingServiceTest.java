package com.example.doremi.service;

import com.example.doremi.exception.InvalidInputException;
import com.example.doremi.model.Command;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class FileProcessingServiceTest {

    FileProcessingService service;

    @BeforeEach
    public void setUp() throws FileNotFoundException {
        service = new FileProcessingService("sample_input/input1.txt");
    }

    @Test
    public void FileProcessingServiceTest() {
        assertThrows(FileNotFoundException.class, () -> new FileProcessingService("abcd"));
    }

    @Test
    public void processLineTest() throws InvalidInputException, IOException {
        Command c = service.processLine();
        Assertions.assertNotNull(c);
    }

}
