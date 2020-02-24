package com.practice.day01.ik;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class MergeKSorted {

    static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }


    static void sort(int[] arr, int start, int end, boolean asc) {
        if (start > end) return;
        swap(arr, start, ThreadLocalRandom.current().nextInt(start, end + 1));
        int pivot = arr[start];
        int left = start;
        for (int i = start + 1; i <= end; i++) {
            if (asc) {
                if (arr[i] < pivot) {
                    left++;
                    swap(arr, left, i);
                }
            } else {
                if (arr[i] > pivot) {
                    left++;
                    swap(arr, left, i);
                }
            }

        }
        swap(arr, left, start);
        sort(arr, start, left - 1, asc);
        sort(arr, left + 1, end, asc);
    }

    static int[] merge(int[] src, int[] target) {
        int count = src.length + target.length;
        int[] result = new int[count];
        System.arraycopy(src, 0, result, 0, src.length);
        System.arraycopy(target, 0, result, src.length, target.length);
        return result;
    }

    public static void main(String[] args) {
        int arr[][] = {{10}, {8}, {34, 26, 20, 13, 11, 7, 4, 4}, {41, 34, 27, 23, 19, 10, 8, 0}, {26, 25, 19, 12, 7, 7, 7, 5},
                {46, 39, 35, 33, 27, 19, 12, 9}, {33, 24, 22, 18, 18, 10, 3, 0}, {42, 35, 35, 30, 21, 20, 12, 9}, {42, 33, 24, 21, 12, 12, 8, 7},
                {29, 23, 21, 18, 18, 11, 8, 7}, {35, 30, 30, 23, 15, 14, 8, 7}, {20, 18, 17, 16, 12, 11, 5, 4}
        };
        int[] result = arr[0];

        for (int i = 1; i < arr.length; i++) {
            result = merge(result, arr[i]);
        }
        System.out.println(result[0] < result[1] ? true : false);

        sort(result, 0, result.length - 1, result[0] < result[1] ? true : false);

        System.out.println(Arrays.toString(result));
    }
}
