package com.practice.day01.ik.sorting.heap;

import com.practice.day01.ik.sorting.Sort;
import com.practice.day01.ik.sorting.selection.SelectionSortImpl;

public class HeapSortImpl implements Sort {

    /**
     * In order to create a max heap, we will compare current element with its children and find the maximum,
     * if current element is not maximum then exchange it with maximum of left or right child.
     *
     * @param arr
     * @param n
     * @param i
     */
    private void heapify(int[] arr, int n, int i) {
        int largest = i;
        int leftPos = 2 * n + 1;
        int rightPos = 2 * n + 2;

        if (leftPos < n && arr[leftPos] > arr[largest])
            largest = leftPos;
        if (rightPos < n && arr[rightPos] > arr[largest])
            largest = rightPos;
        if (i != largest) {
            Sort.swap(arr, i, largest);
            heapify(arr, n, largest);
        }
    }

    /**
     * Since heap sort is inplace sorting algorithm, space complexity is o(1).
     * You don’t need any extra space except swapping variable in heap sort.
     * <p>
     * Best case : O(nlogn)
     * Average case : O(nlogn)
     * Worst case : O(nlogn)
     *
     * @param arr
     */
    @Override
    public void sort(int[] arr) {
        int n = arr.length;
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);

        for (int i = n - 1; i >= 0; i--) {
            Sort.swap(arr, i, 0);
            heapify(arr, i, 0);
        }
    }

    public static void main(String[] args) {
        int[] arr = {0, 8, 12, 45, -19, -111, 0x7fffffff, 6, 8, 6, 1};
        new SelectionSortImpl().sort(arr);
        Sort.print(arr);
    }
}
