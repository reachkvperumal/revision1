package com.practice.day01;

import java.util.Random;
import java.util.stream.IntStream;

public interface Sort {
    void sort(int[] arr);

    static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    static int[] generateRandomNumbers(int i) {
        return new Random().ints(0, i + 1).limit(i).toArray();
    }

    static void print(int[] arr) {
        IntStream.of(arr).forEach(System.out::println);
    }
}
