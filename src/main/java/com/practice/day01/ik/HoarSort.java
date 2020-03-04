package com.practice.day01.ik;

import java.util.Arrays;

public class HoarSort {

    static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    static int partioning(int[] arr, int start, int end) {
        int pivot = arr[start];
        int i = start - 1;
        int j = end + 1;
        while (true) {
            do {
                i++;
            } while (arr[i] < pivot);

            do {
                j--;
            } while (arr[j] > pivot);

            if (i >= j)
                return j;
            swap(arr, i, j);

        }
    }

    static void sort(int[] arr, int start, int end) {
        if (start < end) {
            int partion = partioning(arr, start, end);
            sort(arr, start, partion);
            sort(arr, partion + 1, end);
        }
    }

    public static void main(String[] args) {
        int[] arr = {10, 7, 8, 9, 1, 5};
        sort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

}
