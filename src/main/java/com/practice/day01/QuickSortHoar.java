package com.practice.day01;

public class QuickSortHoar implements Sort {

    static int partition(int[] arr, int start, int end) {
        int pivot = arr[start];
        int i = start - 1, j = end + 1;
        while (true) {
            do {
                i++;
            } while (arr[i] < pivot);
            do {
                j--;
            } while (arr[j] > pivot);
            if (i < j)
                Sort.swap(arr, i, j);
            else
                return j;
        }
    }

    static void sortHelper(int[] arr, int start, int end) {
        if (start < end) {
            int i = partition(arr, start, end);
            sortHelper(arr, start, i);
            sortHelper(arr, i + 1, end);
        }
    }

    @Override
    public void sort(int[] arr) {
        if (arr == null || arr.length <= 1) return;
        sortHelper(arr, 0, arr.length - 1);
    }

    public static void main(String[] args) {
        int[] input0 = {0, 5, 10, 3, 6, 2, 4, 1, 7, 8, 9, -4, 11};
        int[] input1 = {93, 12, 56, 68, 29, 18, 23, 54, 88, 32, 40, 46, 65, 79, 14, 69, 56, 57, 50, 15, 30, 49, 88, 85, 6, 32, 6, 8, 61, 31, 32, 33, 48, 34, 57, 18, 98, 59, 24, 41};

        Sort quickSortHoar = new QuickSortHoar();
        quickSortHoar.sort(input0);
        Sort.print(input0);
        quickSortHoar.sort(input1);
        Sort.print(input1);
    }
}
