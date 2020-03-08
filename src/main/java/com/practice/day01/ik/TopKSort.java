package com.practice.day01.ik;

import java.util.Arrays;

public class TopKSort {

    static void sort(int[] A, int size) {

        for (int i = 1; i < size; i++) {
            int v = A[i];
            int j = i;


    /* Move elements of A[0..i-1], that are greater than key, to one
        position ahead of their current position.
        This loop will run at most k times */
            while (j > 0 && A[j - 1] > v) {
                A[j] = A[j - 1];
                j--;
            }
            A[j] = v;
        }

    }

    public static void main(String[] args) {
        int[] arr = {4, 1, 5, 2, 6};
        sort(arr, 2);
        System.out.println(Arrays.toString(arr));
    }
}
