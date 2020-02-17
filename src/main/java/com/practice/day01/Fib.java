package com.practice.day01;

public class Fib {

    static int fib(int n) {

        int[] f = new int[n + 2];
        f[0] = 0;
        f[1] = 1;

        for (int i = 2; i <= n; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }
        return f[n];
    }

    public static void main(String[] args) {
        for (int i = 0; i <= 10; i++)
            System.out.println(fib(i));

    }

}
