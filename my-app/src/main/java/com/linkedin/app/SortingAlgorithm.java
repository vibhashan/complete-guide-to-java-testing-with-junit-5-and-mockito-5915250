package com.linkedin.app;

public class SortingAlgorithm {

  public int[] sort(int[] array) {
    if (array == null || array.length < 2) {
      return array;
    }

    int mid = array.length / 2;
    int[] left = new int[mid];
    int[] right = new int[array.length - mid];

    System.arraycopy(array, 0, left, 0, mid);
    System.arraycopy(array, mid, right, 0, array.length - mid);

    sort(left);
    sort(right);

    merge(array, left, right);
    return array;
  }

  private void merge(int[] array, int[] left, int[] right) {
    int i = 0, j = 0, k = 0;
    while (i < left.length && j < right.length) {
      if (left[i] <= right[j]) {
        array[k++] = left[i++];
      } else {
        array[k++] = right[j++];
      }
    }
    while (i <= left.length) {
      array[k++] = left[i++];
    }
    while (j < right.length) {
      array[k++] = right[j++];
    }
  }
}
