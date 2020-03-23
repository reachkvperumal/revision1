package com.practice.day01.bloomberg.arrays;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KSortedArray {

    /**
     * o(n log(k)) optimal way to sort a k sorted array.
     *
     * @param arr
     * @param k
     */
    static void sort(int[] arr, int k) {
        int n = arr.length;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i = 0; i < k && i < n; i++) {
            minHeap.add(arr[i]);
        }

        int readIdx = k;
        int writeIdx = 0;

        while (readIdx < n) {
            minHeap.add(arr[readIdx++]);
            arr[writeIdx++] = minHeap.poll();
        }

        while (!minHeap.isEmpty())
            arr[writeIdx++] = minHeap.poll();

    }

    public static void main(String[] args) {
        int[] arr1 = {6, 5, 4, 3, 8, 10, 9};
        sort(arr1, 3);
        System.out.println(Arrays.toString(arr1));

        int[] arr2 = {10, 9, 8, 7, 4, 70, 60, 50};
        sort(arr2, 4);
        System.out.println(Arrays.toString(arr2));
    }
}
