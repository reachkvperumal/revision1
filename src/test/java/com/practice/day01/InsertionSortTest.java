package com.practice.day01;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class InsertionSortTest {

    private static void sort(int[] arr) {

        for (int i = 1; i < arr.length; i++) {
            int v = arr[i];
            int j = i;

            while (j > 0 && arr[j - 1] > v) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = v;
        }
    }

    @Test
    public void test() {
        int[] arr = {3, 8, 5, 4, 1, 9, -2};
        sort(arr);
        System.out.println(Arrays.toString(arr));

    }
}
