package com.practice.day01;

import java.util.stream.IntStream;

public class MergeSort {

    static void merge(int[] arr, int start, int middle, int end) {
        int[] aux = new int[end - start + 1];
        int i = start, j = middle + 1, k = 0;
        while (i <= middle && j <= end) {
            if (arr[i] <= arr[j]) {
                aux[k] = arr[i];
                k += 1;
                i += 1;
            } else {
                aux[k] = arr[j];
                k += 1;
                j += 1;
            }
        }
        while (i <= middle) {
            aux[k] = arr[i];
            k += 1;
            i += 1;
        }
        while (j <= end) {
            aux[k] = arr[j];
            k += 1;
            j += 1;
        }
        for (i = start; i <= end; i++)
            arr[i] = aux[i - start];
    }

    static void sort(int[] arr, int start, int end) {

        if (start < end) {
            int middle = (start + end) / 2;
            sort(arr, start, middle);
            sort(arr, middle + 1, end);
            merge(arr, start, middle, end);
        }
    }


    public static void main(String[] args) {
        int[] input = {8, 6, 3, 9, 0, 2, 4, 1, 7, 5};
        sort(input, 0, input.length - 1);
        IntStream.of(input).forEach(System.out::println);
        System.out.println(0x7fffffff);
    }

}
