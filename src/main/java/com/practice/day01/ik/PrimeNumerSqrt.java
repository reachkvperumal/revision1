package com.practice.day01.ik;

public class PrimeNumerSqrt {

    static boolean isPrime(int n) {
        if (n <= 1) return false;
        if (n <= 3) return true;
        if (n % 2 == 0 || n % 3 == 0) return false;
        for (int i = 5; i * i <= n; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPrime(4));
        System.out.println(isPrime(6));
        System.out.println(isPrime(1_000_000_007));
    }
}
