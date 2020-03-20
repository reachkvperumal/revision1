package com.practice.day01;


import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

import static org.junit.jupiter.api.Assertions.*;

public class SortTest {

    @Test
    public void testIntMin() {
        Integer i = Integer.MIN_VALUE;
        int f = 0x80000000;
        assertTrue(i.compareTo(f) == 0);
    }

    @Test
    public void fibTest() {

        //Stream.iterate(new Long[]{0l, 1l}, a -> new Long[]{a[1], a[0] + a[1]}).limit(20).forEach(a -> System.out.println(a[0]));


        for (int i = 0; i <= 10; i++)
            System.out.println(fib(i));

        assertEquals(0, 0 / 2);

        int actual = ThreadLocalRandom.current().nextInt(100000, 999999);
        int num = actual;
        int reversed = 0;
        while (num != 0) {
            reversed = (reversed * 10) + (num % 10);
            num /= 10;
        }

        System.out.printf("Actual # : %d%nRevesed #: %d%n", actual, reversed);

        Deque<Integer> deque = new ArrayDeque<>();
        System.out.println(deque.size());
    }


    @Test
    public void test() {
        assertEquals(1000000007, (int) Math.pow(10, 9) + 7);
        int mod = (int) Math.pow(10, 9) + 7;
        assertEquals(1000000007, mod);
        assertEquals(1_000_000_007, mod);
        System.out.println(-0x7fff);
        System.out.println(1_000_000_007 - 0x7fff);
        System.out.println((1_000_000_007 + -0x7fff) % 1_000_000_007);
        int i = 1073741824;
        System.out.println(i - mod);

        System.out.println(isPrime(1_000_000_007));
        assertTrue(isPrime(1_000_000_007));
        System.out.println("---------------SQRT-----------------------------");
        System.out.println(isPrimeSqrt(1_000_000_007));

    }

    private boolean isPrimeSqrt(int n) {
        if (n <= 1) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    @Test
    public void firstNotRepeatTest() {
        String test = "abcabcxyzxyzikv";
        Map<Character, Integer> map = new LinkedHashMap<>();
        for (char c : test.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        System.out.println(map);
        assertEquals('i', map.entrySet().stream().filter(o -> o.getValue().intValue() == 1).findFirst().map(o -> o.getKey()).get());
    }


    private boolean isPrime(int n) {
        if (n <= 1) return false;
        if (n <= 3) return true;

        if ((n % 2 == 0) || (n % 3 == 0))
            return false;

        for (int i = 5; i * i <= n; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0)
                return true;
        }
        return true;
    }

    private int fib(int n) {
        int[] result = new int[2 + n];
        result[0] = 0;
        result[1] = 1;

        for (int i = 2; i <= n; i++)
            result[i] = result[i - 1] + result[i - 2];

        return result[n];
    }

    @Test
    public void kSortTest() {
        int arr[][] = {{10}, {8}, {34, 26, 20, 13, 11, 7, 4, 4}, {41, 34, 27, 23, 19, 10, 8, 0}, {26, 25, 19, 12, 7, 7, 7, 5},
                {46, 39, 35, 33, 27, 19, 12, 9}, {33, 24, 22, 18, 18, 10, 3, 0}, {42, 35, 35, 30, 21, 20, 12, 9}, {42, 33, 24, 21, 12, 12, 8, 7},
                {29, 23, 21, 18, 18, 11, 8, 7}, {35, 30, 30, 23, 15, 14, 8, 7}, {20, 18, 17, 16, 12, 11, 5, 4}
        };

        boolean sortType = getSortType(arr);
        assertFalse(sortType);

        System.out.println(Double.POSITIVE_INFINITY - Double.POSITIVE_INFINITY);
        System.out.println(Double.POSITIVE_INFINITY * Double.POSITIVE_INFINITY);

    }

    static boolean getSortType(int[][] arr) {
        boolean isMinHeap = true;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i].length > 1 && (arr[i][0] - arr[i][arr[i].length - 1] > 0)) {
                isMinHeap = false;
                break;
            }
        }
        return isMinHeap;
    }

    static boolean isMatch(String s, String p) {
        boolean[][] result = new boolean[s.length()][p.length()];
        result[s.length()][p.length()] = true;

        for (int i = s.length(); i >= 0; i--) {
            for (int j = p.length() - 1; j >= 0; j--) {
                boolean firstMatch = i < s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');
                if (j + 1 < p.length() && p.charAt(j + 1) == '*')
                    result[i][j] = result[i][j + 2] || firstMatch && result[i + 1][j];
                else
                    result[i][j] = firstMatch && result[i + 1][j + 1];
            }
        }
        return result[0][0];
    }
}
