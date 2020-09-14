package com.algo.recursion.day01;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class RecursionFundamentals {

  private static int square(int n) {
    if (n == 0) {
      return 0;
    } else {
      return square(n - 1) + (2 * n) - 1;
    }
  }

  private static long power(int base, int pow) {
    if (pow == 0) {
      return 1;
    } else {
      return base * power(base, pow - 1);
    }
  }

  private static int sumOfIntegers(int n) {
    if (n == 0) {
      return 0;
    } else {
      return n + sumOfIntegers(n - 1);
    }
  }

  private static int mod(int dividend, int divisor) {
    if (divisor < 1) {
      return -1;
    }

    if (dividend < divisor) {
      return dividend;
    } else {
      return mod(dividend - divisor, divisor);
    }

  }

  private static int fibonacci(int num) {
    if (num <= 1) {
      return num;
    } else {
      return fibonacci(num - 1) + fibonacci(num - 2);
    }
  }

  private static Map<Integer, Integer> iterate(int num) {

    Map<Integer, Integer> result = new HashMap<>();

    IntStream.range(0, num).forEach(i -> {
      result.put(i, fibonacci(i));
    });
    return result;
  }

  private static int gcd(int num1, int num2) {
    if (num1 == num2) {
      return num1;
    }

    if (num1 > num2) {
      return gcd(num1 - num2, num2);
    } else {
      return gcd(num1, num2 - num1);
    }
  }

  private static boolean isPrime(int num, int i) {
    if (num < 2) {
      return false;
    } else if (i == 1) {
      return true;
    } else if (num % i == 0) {
      return false;
    } else {
      return isPrime(num, i - 1);
    }
  }


  private static boolean isPrime(int n) {
    if (n < 2) {
      return false;
    }
    if (n < 4) {
      return true;
    }
    if (n % 2 == 0 || n % 3 == 0) {
      return false;
    }
    for (int i = 5; i * i <= n; i += 6) {
      if (n % i == 0 || n % (i + 2) == 0) {
        return false;
      }
    }
    return true;
  }

  private static int decimalToBinary(int n) {
    if (n == 0) {
      return n;
    } else {
      return n % 2 + 10 * decimalToBinary(n / 2);
    }

  }


  public static void main(String[] args) {
    System.out.println(square(6));
    System.out.println(power(5, 3));
    System.out.println(sumOfIntegers(5));
    System.out.println(mod(27, 5));
    int key = 5;
    System.out.println(iterate(key).get(key - 1));
    System.out.println(gcd(56, 42));

    // System.out.println(isPrime(Integer.MAX_VALUE));
    System.out.println(isPrime(1_000_000_007));
    System.out.println(decimalToBinary(9));
    System.out.println(10 * (4 / 2));
  }

}
