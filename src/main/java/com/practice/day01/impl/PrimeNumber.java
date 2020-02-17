package com.practice.day01.impl;

import java.util.Scanner;

public class PrimeNumber {

    static boolean isPrimeLoop(int num) {
        boolean flag = false;
        for (int i = 2; i <= num / 2; i++) {
            if (num % i == 0) {
                flag = true;
                break;
            }
        }
        return flag;
    }

    static boolean isPrime(int num) {
        boolean flag = false;
        int i = 2;
        while (i <= num / 2) {
            // condition for nonprime number
            if (num % i == 0) {
                flag = true;
                break;
            }
            i++;
        }
        return flag;
    }

    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {
            while (scanner.hasNextInt()) {
                int num = scanner.nextInt();
                if (!isPrime(num))
                    System.out.println(num + " is a prime number.");
                else
                    System.out.println(num + " is not a prime number.");

                if (!isPrimeLoop(num))
                    System.out.println(num + " is a prime number.");
                else
                    System.out.println(num + " is not a prime number.");
            }
        }
    }
}
