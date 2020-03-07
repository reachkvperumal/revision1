package com.practice.day01.ik.sorting.bubble;

import com.practice.day01.ik.sorting.Sort;

public class BubbleSortingImpl implements Sort {

    /**
     * Bubble sort works by iterating first element to last element,
     * comparing two adjacent elements and swapping them if they are not in correct order.
     * Each iteration places next larger value to its correct place
     * <p>
     * Time Complexity:
     * Best case: O(n)
     * Average case: O(n^2)
     * Worst case: O(n^2)
     *
     * @param arr
     */

    @Override
    public void sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1; j++) {
                if (arr[i] < arr[j])
                    Sort.swap(arr, i, j);
            }
        }
    }

    public static void main(String[] args) {
        int arr[] = {0, 8, 12, 45, -19, -111, 0x7fffffff, 6, 8, 6, 1};
        new BubbleSortingImpl().sort(arr);
        Sort.print(arr);
    }
}
