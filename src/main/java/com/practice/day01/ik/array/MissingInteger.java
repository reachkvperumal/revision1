package com.practice.day01.ik.array;

public class MissingInteger {

    static int findMissing(int[] arr) {

        int n = arr.length;

        int contains = 0;

        for (int i = 0; i < n; i++) {
            if (arr[i] == 1) {
                contains++;
                break;
            }
        }
        if (contains == 0)
            return 1;

        if (n == 1)
            return 2;

        for (int i = 0; i < n; i++) {
            if (arr[i] <= 0 || arr[i] > n) {
                arr[i] = 1;
            }
        }

        for (int i = 0; i < n; i++) {
            int a = Math.abs(arr[i]);
            if (a == n)
                arr[0] = -Math.abs(arr[0]);
            else
                arr[a] = -Math.abs(arr[a]);
        }

        for (int i = 1; i < n; i++) {
            if (arr[i] > 0)
                return i;
        }
        if (arr[0] > 0)
            return n;
        return n + 1;
    }

    public static void main(String[] args) {
        //int[] arr = {3, 4, -1, 1};
        int[] arr = {1, 2, 3, 4};
        System.out.println(findMissing(arr));

    }
}
