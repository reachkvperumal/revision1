package com.practice.day01.ik;

import java.util.Arrays;

public class IKMergeSort {

    static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    static void heapify(int[] arr, int n, int i) {
        int largest = i;
        int leftPos = 2 * i + 1;
        int rightPos = 2 * i + 2;

        if (leftPos < n && arr[leftPos] > arr[largest])
            largest = leftPos;

        if (rightPos < n && arr[rightPos] > arr[largest])
            largest = rightPos;

        if (largest != i) {
            swap(arr, i, largest);
            heapify(arr, n, largest);
        }
    }

    static void sort(int[] arr) {
        int n = arr.length;

        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);

        for (int i = n - 1; i >= 0; i--) {
            swap(arr, i, 0);
            heapify(arr, i, 0);
        }
    }

    static void merge(int[] nums1, int m, int[] nums2, int n) {

        int counter = 0;

        for (int i = m / 2; i < m; i++) {
            nums1[i] = nums2[counter++];
        }

        sort(nums1);
        System.out.println(Arrays.toString(nums1));

    }

    public static void main(String[] args) {
        int[] nums1 = {0};
        int[] nums2 = {2, 5, 6};
        merge(nums1, nums1.length, nums2, nums2.length);
    }

}
