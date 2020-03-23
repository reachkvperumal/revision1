package com.practice.day01.bloomberg.number;

public class FibonacciSeries {

    private static int fib(int n) {
        int[] result = new int[2 + n];
        result[0] = 0;
        result[1] = 1;

        for (int i = 2; i <= n; i++)
            result[i] = result[i - 1] + result[i - 2];

        return result[n];
    }

    public static void main(String[] args) {
        System.out.println(fib(10));
    }
}
