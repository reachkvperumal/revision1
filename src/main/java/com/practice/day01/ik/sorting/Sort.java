package com.practice.day01.ik.sorting;

import java.util.Arrays;

public interface Sort {

    void sort(int[] arr);

    static void print(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    static void swap(int[] arr, int i, int j) {
        int T = arr[i];
        arr[i] = arr[j];
        arr[j] = T;
    }
}
