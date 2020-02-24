package com.practice.day01.programiz;

import java.util.Arrays;

public class HeapSort {

    static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    static void heapify(int[] arr, int n, int i) {
        int largest = i;
        int leftPos = 2 * i + 1;
        int rightPos = 2 * i + 2;

        if (leftPos < n && arr[leftPos] > arr[largest])
            largest = leftPos;

        if (rightPos < n && arr[rightPos] > arr[largest])
            largest = rightPos;

        if (i != largest) {
            swap(arr, largest, i);
            heapify(arr, n, largest);
        }
    }

    static void sort(int[] arr) {
        int n = arr.length;
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);

        for (int i = n - 1; i >= 0; i--) {
            swap(arr, i, 0);
            heapify(arr, i, 0);
        }
    }

    public static void main(String[] args) {
        int[] i = {20, 18, 17, 16, 12, 11, 5, 4};
        sort(i);
        System.out.println(Arrays.toString(i));
    }

}
