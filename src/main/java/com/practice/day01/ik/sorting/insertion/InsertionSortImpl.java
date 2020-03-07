package com.practice.day01.ik.sorting.insertion;

import com.practice.day01.ik.sorting.Sort;

public class InsertionSortImpl implements Sort {

    /**
     * Insertion sort works by comparing values at index with all its prior elements.
     * We place value at the index where there are no lesser value to the elements.
     * So when you reach last element,we get a sorted array
     * <p>
     * Best case:  O(n)
     * Average case:  O(n^2)
     * Worst case:  O(n^2)
     *
     * @param arr
     * @param size
     */

    private void sort(int[] arr, int size) {
        if (size <= 1)
            return;
        sort(arr, size - 1);
        int last = arr[size - 1];
        int j = size - 2;
        while (j >= 0 && arr[j] > last) {
            arr[j + 1] = arr[j];
            j -= 1;
        }
        arr[j + 1] = last;
    }

    @Override
    public void sort(int[] arr) {
        this.sort(arr, arr.length);
    }

    public static void main(String[] args) {
        int arr[] = {0, 8, 12, 45, -19, -111, 0x7fffffff, 6, 8, 6, 1};
        new InsertionSortImpl().sort(arr);
        Sort.print(arr);
    }
}
