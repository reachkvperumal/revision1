package com.practice.day01.bloomberg;

public class ReverseNumber {

    static int reverseInt(int num) {
        System.out.println(num);
        int result = 0;

        while (num > 0) {
            result = result * 10 + num % 10;
            num /= 10;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(reverseInt(0x7fffffff));
    }
}
