package com.practice.day01.ik;

public class BoxColoring {

    static int color(int box, int color) {
        int MOD = (int) Math.pow(10, 9) + 7;
        int result = 1;
        for (int i = 1; i <= color; i++)
            result = (result * i) % MOD;

        return result;
    }

    public static void main(String[] args) {
        System.out.println(color(3, 2));

    }
}
