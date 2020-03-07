package com.practice.day01.ik.sorting.quick;

import com.practice.day01.ik.sorting.Sort;

public class QuickSortHoarsImpl implements Sort {

    /**
     * In quick sort, we first choose a pivot and divide into two sublists,
     * one will contain elements lower than pivot and other will have elements greater than pivot
     *
     * @param arr
     * @param start
     * @param end
     * @return
     */
    private int partition(int[] arr, int start, int end) {
        int pivot = arr[start];
        int i = start - 1, j = end + 1;
        while (true) {
            do {
                i++;
            } while (arr[i] < pivot);
            do {
                j--;
            } while (arr[j] > pivot);
            if (i < j)
                Sort.swap(arr, i, j);
            else
                return j;
        }
    }

    /**
     * Quick sort or partition-exchange sort, is a sorting algorithm, which is using divide and conquer algorithm
     *
     * @param arr
     * @param start
     * @param end
     */
    private void sortHelper(int[] arr, int start, int end) {
        if (start < end) {
            int i = partition(arr, start, end);
            sortHelper(arr, start, i);
            sortHelper(arr, i + 1, end);
        }
    }

    /**
     * Best Case : O(n log n)
     * Average Case : O(n log n)
     * Worst Case : O(n^2)
     *
     * @param arr
     */

    @Override
    public void sort(int[] arr) {

        this.sortHelper(arr, 0, arr.length - 1);

    }

    public static void main(String[] args) {
        int[] arr = {93, 12, 56, 68, 29, -18, 23, 54, 88, 32, 40, 46, 65, 79, 14, 69, 56, 57, 50, 15, 30, 49, 88, 85,
                6, 32, 6, 8, 61, 31, 0x7fffffff, 32, 33, 48, 34, 57, 0x80000000, 18, 98, 59, 24, 41};
        new QuickSortHoarsImpl().sort(arr);
        Sort.print(arr);
    }
}
