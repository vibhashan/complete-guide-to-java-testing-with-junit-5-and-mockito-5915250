package com.linkedin.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FileProcessorTest {

    private static final Path INPUT_DIR = Paths.get("tempInputDir");
    private static final Path OUTPUT_DIR = Paths.get("tempOutputDir");

    @BeforeEach
    void setUp() throws IOException {
        Files.createDirectories(INPUT_DIR);
        Files.createDirectories(OUTPUT_DIR);
    }

    @AfterEach
    void tearDown() throws IOException {
        deleteDirectoryRecursively(INPUT_DIR);
        deleteDirectoryRecursively(OUTPUT_DIR);
    }

    private void deleteDirectoryRecursively(Path path) throws IOException {
        if (Files.exists(path)) {
            Files.walk(path)
                    .map(Path::toFile)
                    .forEach(file -> file.delete());
            Files.deleteIfExists(path);
        }
    }

    @Test
    void convertFilesToUpperCase() throws IOException {
        Path inputFile = INPUT_DIR.resolve("sample.txt");
        Files.writeString(inputFile, "Hello, JUnit 5!");

        FileProcessor fileProcessor = new FileProcessor();
        fileProcessor.convertFilesToUpperCase(INPUT_DIR, OUTPUT_DIR);

        Path outputFile = OUTPUT_DIR.resolve("sample.txt");
        assertTrue(Files.exists(outputFile));
        assertEquals("HELLO, JUNIT 5!", Files.readString(outputFile));
    }

    @Test
    void convertFilesToUpperCaseWithEmptyInputDir() throws IOException {
        FileProcessor fileProcessor = new FileProcessor();

        fileProcessor.convertFilesToUpperCase(INPUT_DIR, OUTPUT_DIR);

        assertTrue(Files.isDirectory(OUTPUT_DIR));
        assertEquals(0, Files.list(OUTPUT_DIR).count());
    }
}
