package com.practice.day01;

import java.util.Random;

public class QuickSort implements Sort {
    static void sortHelper(int[] arr, int start, int end) {
        if (start >= end) return;
        int i1 = new Random().nextInt((end - start) + 1) + start;
        //Sort.swap(arr, start, ThreadLocalRandom.current().nextInt(start, end + 1));
        Sort.swap(arr, start, i1);
        int pivot = arr[start];
        int left = start;
        for (int i = start + 1; i <= end; i++) {
            if (arr[i] < pivot) {
                left++;
                Sort.swap(arr, left, i);
            }
        }
        Sort.swap(arr, start, left);
        sortHelper(arr, start, left - 1);
        sortHelper(arr, left + 1, end);
    }


    @Override
    public void sort(int[] arr) {
        sortHelper(arr, 0, arr.length - 1);
    }

    public static void main(String[] args) {
        //int[] input0 = Sort.generateRandomNumbers(0x7ffff);
        // int[] input1 = {93, 12, 56, 68, 29, 18, 23, 54, 88, 32, 40, 46, 65, 79, 14, 69, 56, 57, 50, 15, 30, 49, 88, 85, 6, 32, 6, 8, 61, 31, 32, 33, 48, 34, 57, 18, 98, 59, 24, 41};
        int[] input1 = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        QuickSort sort = new QuickSort();

        //sort.sort(input0);
        sort.sort(input1);
//        Sort.print(input0);
        Sort.print(input1);

        //   System.out.println(0x7ffff);

    }


}
