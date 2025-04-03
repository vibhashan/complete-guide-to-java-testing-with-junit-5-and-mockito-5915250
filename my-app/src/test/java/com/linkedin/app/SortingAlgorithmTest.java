package com.linkedin.app;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

import java.util.stream.Stream;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class SortingAlgorithmTest {
	private static SortingAlgorithm algorithm;

	@BeforeAll
	static void setUp() {
		algorithm = new SortingAlgorithm();
	}

	@AfterAll
	static void tearDown() {
		algorithm = null;
	}

	private static Stream<Arguments> generateData() {
		return Stream.of(Arguments.of(new int[] { 1, 2, 3 }, new int[] { 1, 2, 3 }),
				Arguments.of(new int[] { 5, 8, 1, 3, 6 }, new int[] { 1, 3, 5, 6, 8 }),
				Arguments.of(new int[] { 5, 8, 8, 3, 6 }, new int[] { 3, 5, 6, 8, 8 }),
				Arguments.of(new int[] {}, new int[] {}), Arguments.of(null, null),
				Arguments.of(new int[] { -4, -8, -1, 0, 1 }, new int[] { -8, -4, -1, 0, 1 }));
	}

	@ParameterizedTest
	@MethodSource("generateData")
	void sort(int[] input, int[] expected) {
		assumeTrue(algorithm != null); // Just for fun
		assertArrayEquals(expected, algorithm.sort(input));
	}

}
