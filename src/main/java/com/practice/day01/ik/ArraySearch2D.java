package com.practice.day01.ik;

public class ArraySearch2D {

    static String search(int[][] arr, int x) {
        String result = "not present";

        int n = arr.length;

        int i = 0, j = arr[i].length - 1;

        while (i < n && j >= 0) {
            int current = arr[i][j];
            if (current == x)
                return "present";

            if (current > x)
                j--;
            else {
                i++;
                if (i < n)
                    j = arr[i].length - 1;
            }

        }
        return result;
    }

    public static void main(String[] args) {
        int mat[][] = {{10, 20, 30, 40},
                {15, 25, 35, 45},
                {27, 29, 37, 48},
                {32, 33, 39, 50}};
        int[][] arr = {{1, 2, 3, 12}, {4, 5, 6, 45}, {7, 8, 9, 78}};
        System.out.println(search(arr, 10));
    }
}
