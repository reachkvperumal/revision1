package com.practice.day01.ik;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MergeSort {

    static List<Integer> mergeSort(List<Integer> arr) {

        if (arr == null || arr.size() == 0)
            return arr;

        int[] aux = arr.stream().mapToInt(Integer::intValue).toArray();

        split(aux, 0, aux.length - 1);
        return Arrays.stream(aux).mapToObj(Integer::valueOf).collect(Collectors.toList());
    }


    static void split(int[] arr, int low, int high) {
        if (low == high)
            return;
        int mid = low + (high - low) / 2;
        split(arr, low, mid);
        split(arr, mid + 1, high);
        merge(arr, low, mid, high);
    }

    static void merge(int[] arr, int low, int mid, int high) {
        int[] left = Arrays.copyOfRange(arr, low, mid + 1);
        int[] right = Arrays.copyOfRange(arr, mid + 1, high + 1);

        int l = 0, r = 0, i = low;

        while (l < left.length && r < right.length) {
            if (left[l] <= right[r])
                arr[i++] = left[l++];
            else
                arr[i++] = right[r++];
        }

        while (l < left.length)
            arr[i++] = left[l++];

        while ((r < right.length))
            arr[i++] = right[r++];

    }

    public static void main(String[] args) {
        int[] arr = {1, 7, 5, 3};
        System.out.println(mergeSort(Arrays.stream(arr).boxed().collect(Collectors.toList())));
        int[] arr1 = {93, 12, 56, 68, 29, 18, 23, 54, 88, 32, 40, 46, 65, 79, 14, 69, 56, 57, 50, 15, 30, 49, 88, 85, 6, 32, 6, 8, 61, 31, 32, 33, 48, 34, 57, 18, 98, 59, 24, 41};
        System.out.println(mergeSort(Arrays.stream(arr1).boxed().collect(Collectors.toList())));
    }

}
