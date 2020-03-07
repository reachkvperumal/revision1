package com.practice.day01.ik.array;

public class HourGlass {

    static int hourGlass(int[][] arr) {

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length - 2; i++) {
            for (int j = 0; j < arr[i].length - 2; j++) {
                int sum = arr[i][j] +
                        arr[i][j + 1] +
                        arr[i][j + 2] +
                        arr[i + 1][j + 1] +
                        arr[i + 2][j] +
                        arr[i + 2][j + 1] +
                        arr[i + 2][j + 2];
                max = Math.max(max, sum);
            }
        }
        return max;
    }

    private static int[][] scenario1() {
        int[][] arr = {
                {0, 6, -7, 1, 6, 3},
                {-8, 2, 8, 3, -2, 7},
                {-3, 3, -6, -3, 0, -6},
                {5, 0, 5, -1, -5, 2},
                {6, 2, 8, 1, 3, 0},
                {8, 5, 0, 4, -7, 4}};
        return arr;
    }

    private static int[][] scenario2() {
        int[][] arr = {{3, 7, -3, 0, 1, 8},
                {1, -4, -7, -8, -6, 5},
                {-8, 1, 3, 3, 5, 7},
                {-2, 4, 3, 1, 2, 7},
                {2, 4, -5, 1, 8, 4},
                {5, -7, 6, 5, 2, 8}};
        return arr;
    }

    private static int[][] scenario3() {
        int[][] arr = {{7, 6, 8, 2, 4, 3},
                {7, 3, 3, 0, 6, 1},
                {3, 8, 7, 7, 2, 2},
                {0, 8, 6, 8, 6, 1},
                {7, 1, 6, 0, 2, 4},
                {2, 7, 8, 1, 7, 4}};
        return arr;
    }

    public static void main(String[] args) {
        System.out.println(hourGlass(scenario1())); //25
        System.out.println(hourGlass(scenario2())); //33
        System.out.println(hourGlass(scenario3())); //44
    }

}
