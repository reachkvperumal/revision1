package com.practice.day01;

import java.util.stream.IntStream;

public class InsertionSort {
    static void compute(int[] arr, int size) {

        if (size <= 1) return;
        compute(arr, size - 1);
        int last = arr[size - 1];
        int j = size - 2;

        while (j >= 0 && arr[j] > last) {
            arr[j + 1] = arr[j];
            j -= 1;
        }
        arr[j + 1] = last;
    }


    public static void main(String[] args) {
        int[] input = {6, 3, 9, 2, 4, 1, 7, 5};
        compute(input, input.length);
        IntStream.of(input).forEach(System.out::println);
    }
}
