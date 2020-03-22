package com.practice.day01.ik.sorting.merge;

import com.practice.day01.ik.sorting.Sort;

import java.util.Arrays;

public class MergeSortImpl implements Sort {

    /**
     * Divide list into sublist of about half size in each iteration until each sublist has only one element.
     *
     * @param arr
     * @param start
     * @param end
     */
    private static void split(int[] arr, int start, int end) {
        if (start < end) {
            //int mid = start + (end - start) / 2;
            int mid = (start + end) >>> 1;
            split(arr, start, mid);
            split(arr, mid + 1, end);
            sort(arr, start, mid, end);
        }
    }

    /**
     * Merge each sublist repeatedly to create sorted list. It will run until we have only 1 sorted list.
     * This will be the sorted list.
     *
     * @param arr
     * @param start
     * @param mid
     * @param end
     */
    private static void sort(int[] arr, int start, int mid, int end) {
        int[] left = Arrays.copyOfRange(arr, start, mid + 1);
        int[] right = Arrays.copyOfRange(arr, mid + 1, end + 1);
        int l = 0, r = 0, i = start;

        while (l < left.length && r < right.length) {
            if (left[l] <= right[r])
                arr[i++] = left[l++];
            else
                arr[i++] = right[r++];
        }

        while (l < left.length)
            arr[i++] = left[l++];

        while ((r < right.length))
            arr[i++] = right[r++];
    }

    /**
     * Merge sort is divide and conquer sorting algorithm. It is efficient, comparison based sorting algorithm.
     * <p>
     * Best case: O(nlogn)
     * Average case: O(nlogn)
     * Worst case: O(nlogn)
     *
     * @param arr
     */
    @Override
    public void sort(int[] arr) {
        split(arr, 0, arr.length - 1);
    }

    public static void main(String[] args) {
        int[] arr = {99, 9, 98, 97, 96, 95, 94, 93, 92, 91, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        new MergeSortImpl().sort(arr);
        Sort.print(arr);
        int arr1[] = {0, 8, 12, 45, -19, -111, 0x7fffffff, 6, 8, 6, 1};
        new MergeSortImpl().sort(arr1);
        Sort.print(arr1);
    }
}
