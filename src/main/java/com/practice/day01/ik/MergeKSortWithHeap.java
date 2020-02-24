package com.practice.day01.ik;

import java.util.Arrays;

public class MergeKSortWithHeap {

    static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    static int[] appendArray(int[] arr1, int[] arr2) {
        int[] result = new int[arr1.length + arr2.length];
        System.arraycopy(arr1, 0, result, 0, arr1.length);
        System.arraycopy(arr2, 0, result, arr1.length, arr2.length);
        return result;
    }

    static void heapify(int[] arr, int n, int i, boolean asc) {
        int largest = i;
        int leftPos = 2 * i + 1;
        int rightPos = 2 * i + 2;

        if (leftPos < n) {
            if (asc) {
                if (arr[leftPos] > arr[largest])
                    largest = leftPos;
            } else {
                if (arr[leftPos] < arr[largest])
                    largest = leftPos;
            }

        }

        if (rightPos < n) {
            if (asc) {
                if (arr[rightPos] > arr[largest])
                    largest = rightPos++;
            } else {
                if (arr[rightPos] < arr[largest])
                    largest = rightPos++;
            }
        }

        if (largest != i) {
            swap(arr, largest, i);
            heapify(arr, n, largest, asc);
        }
    }

    static void sort(int[] arr, boolean asc) {
        int n = arr.length;
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i, asc);

        for (int i = n - 1; i >= 0; i--) {
            swap(arr, i, 0);
            heapify(arr, i, 0, asc);
        }
    }

    public static void main(String[] args) {
        int arr[][] = {{10}, {8}, {34, 26, 20, 13, 11, 7, 4, 4}, {41, 34, 27, 23, 19, 10, 8, 0}, {26, 25, 19, 12, 7, 7, 7, 5},
                {46, 39, 35, 33, 27, 19, 12, 9}, {33, 24, 22, 18, 18, 10, 3, 0}, {42, 35, 35, 30, 21, 20, 12, 9}, {42, 33, 24, 21, 12, 12, 8, 7},
                {29, 23, 21, 18, 18, 11, 8, 7}, {35, 30, 30, 23, 15, 14, 8, 7}, {20, 18, 17, 16, 12, 11, 5, 4}
        };

        int[] result = arr[0];
        for (int i = 1; i < arr.length; i++)
            result = appendArray(result, arr[i]);


        boolean asc = result[0] < result[1] ? true : false;

        sort(result, asc);
        System.out.println(Arrays.toString(result));

    }

}
