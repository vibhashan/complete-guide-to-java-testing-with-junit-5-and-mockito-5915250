package com.linkedin.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

class FileProcessorTest {
	@TempDir
	private Path tempDir;

	private Path inputDir;
	private Path outputDir;

	@BeforeEach
	void setUp() throws IOException {
		inputDir = tempDir.resolve("input");
		outputDir = tempDir.resolve("output");

		Files.createDirectory(inputDir);
		Files.createDirectory(outputDir);
	}

	@Test
	void convertFilesToUpperCase() throws IOException {
		Path inputFile = inputDir.resolve("sample.txt");
		Files.writeString(inputFile, "Hello, JUnit 5!");

		FileProcessor fileProcessor = new FileProcessor();
		fileProcessor.convertFilesToUpperCase(inputDir, outputDir);

		Path outputFile = outputDir.resolve("sample.txt");
		assertTrue(Files.exists(outputFile));
		assertEquals("HELLO, JUNIT 5!", Files.readString(outputFile));
	}

	@Test
	void convertFilesToUpperCaseWithEmptyInputDir() throws IOException {
		FileProcessor fileProcessor = new FileProcessor();
		fileProcessor.convertFilesToUpperCase(inputDir, outputDir);

		assertTrue(Files.isDirectory(outputDir));
		assertEquals(0, Files.list(outputDir).count());
	}
}
