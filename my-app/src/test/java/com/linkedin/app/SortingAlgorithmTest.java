package com.linkedin.app;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

public class SortingAlgorithmTest {

  private static final SortingAlgorithm underTest = new SortingAlgorithm();

  @Test
  public void sort_unsortedArray() {
    int[] input = { 5, 3, 8, 4, 2 };
    int[] expected = { 2, 3, 4, 5, 8 };
    assertArrayEquals(expected, underTest.sort(input));
  }

  @Test
  public void sort_sortedArray() {
    int[] input = { 1, 2, 3, 4, 5 };
    assertArrayEquals(input, underTest.sort(input));
  }

  @Test
  public void sort_reversedSorted() {
    int[] input = { 9, 7, 5, 3, 1 };
    int[] expected = { 1, 3, 5, 7, 9 };
    assertArrayEquals(expected, underTest.sort(input));
  }

  @Test
  public void sort_empty() {
    assertArrayEquals(new int[] {}, underTest.sort(new int[] {}));
  }

  @Test
  public void sort_null() {
    assertArrayEquals(null, underTest.sort(null));
  }

  @Test
  public void sort_negative() {
    int[] input = { -5, -3, -8, -4, -2 };
    int[] expected = { -8, -5, -4, -3, -2 };
    assertArrayEquals(expected, underTest.sort(input));
  }

}
