package com.practice.day01.ik.sorting.hybrid;

import com.practice.day01.ik.sorting.Sort;

import java.util.Arrays;

public class QuickSort {

    static void insertionSort(int[] arr, int start, int end) {
        for (int i = start + 1; i <= end; i++) {
            int v = arr[i];
            int j = i;

            while (j > 0 && arr[j - 1] > v) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = v;
        }
    }

    static int partition(int[] arr, int start, int end) {
        int pivot = arr[start];
        int i = start - 1, j = end + 1;

        while (true) {
            do {
                i++;
            } while (arr[i] < pivot);
            do {
                j--;
            } while (arr[j] > pivot);

            if (i < j) {
                Sort.swap(arr, i, j);
            } else
                return j;
        }
    }

    static void sort(int[] arr, int start, int end) {

        while (start < end) {
            if (end - start < 10) {
                insertionSort(arr, start, end);
                break;
            } else {
                int pivot = partition(arr, start, end);
                if (pivot - start < end - pivot) {
                    sort(arr, start, pivot - 1);
                    start = pivot + 1;
                } else {
                    sort(arr, pivot + 1, end);
                    end = pivot - 1;
                }
            }
        }
    }

    public static void main(String[] args) {

        int[] arr = {10, 8, 34, 26, 20, 13, 11, 7, 4, 4, 41, 34, 27, 23, 19, 10, 8, 0, 26, 25, 19, 12, 7, 7, 7, 5,
                46, 39, 35, 33, 27, 19, 12, 9, 33, 24, 22, 18, 18, 10, 3, 0, 42, 35, 35, 30, 21, 20, 12, 9, 42, 33, 24, 21, 12, 12, 8, 7,
                29, 23, 21, 18, 18, 11, 8, 7, 35, 30, 30, 23, 15, 14, 8, 7, 20, 18, 17, 16, 12, 11, 5, 4};

        sort(arr, 0, arr.length - 1);

        System.out.println(Arrays.toString(arr));
    }
}
