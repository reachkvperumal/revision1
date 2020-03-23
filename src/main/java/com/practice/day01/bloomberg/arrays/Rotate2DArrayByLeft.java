package com.practice.day01.bloomberg.arrays;

import java.util.Arrays;

public class Rotate2DArrayByLeft {

    static void rotateByRight(int[][] arr) {
        int N = arr.length;

        for (int i = 0; i < N / 2; i++) {
            for (int j = i; j < N - i - 1; j++) {
                int tmp = arr[i][j];
                arr[i][j] = arr[N - 1 - j][i];
                arr[N - 1 - j][i] = arr[N - 1 - i][N - 1 - j];
                arr[N - 1 - i][N - 1 - j] = arr[j][N - 1 - i];
                arr[j][N - 1 - i] = tmp;
            }
        }
    }

    static void rotateByLeft(int[][] arr) {
        int N = arr.length;

        for (int i = 0; i < N / 2; i++) {
            for (int j = i; j < N - i - 1; j++) {
                int tmp = arr[i][j];
                arr[i][j] = arr[j][N - 1 - i];
                arr[j][N - 1 - i] = arr[N - 1 - i][N - 1 - j];
                arr[N - 1 - i][N - 1 - j] = arr[N - 1 - j][i];
                arr[N - 1 - j][i] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        int arr[][] = {{1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}};
        rotateByLeft(arr);
        rotateByRight(arr);

        for (int i = 0; i < arr.length; i++)
            System.out.println(Arrays.toString(arr[i]));

        int v = -8;
        int j = -5;
        System.out.println(v - j);

    }

}
