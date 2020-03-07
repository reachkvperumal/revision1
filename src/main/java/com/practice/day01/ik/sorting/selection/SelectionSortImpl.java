package com.practice.day01.ik.sorting.selection;

import com.practice.day01.ik.sorting.Sort;

public class SelectionSortImpl implements Sort {

    /**
     * Selection sort is an in place comparison sorting algorithm.
     * It is very simple to implement but it does not go well with large number of inputs.
     * <p>
     * Best case : O(N^2)
     * Average case : O(N^2)
     * Worst case : O(N^2)
     *
     * @param arr
     */
    @Override
    public void sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int cur = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[cur] > arr[j])
                    cur = j;
            }
            if (i != cur)
                Sort.swap(arr, i, cur);
        }

    }

    public static void main(String[] args) {
        int[] arr = {0, 8, 12, 45, -19, -111, 0x7fffffff, 6, 8, 6, 1};
        new SelectionSortImpl().sort(arr);
        Sort.print(arr);
    }
}
