package com.practice.day01.bloomberg.word;

import java.util.stream.IntStream;

public class WordReverse {

    static void swap(char[] arr, int i, int j) {
        char T = arr[i];
        arr[i] = arr[j];
        arr[j] = T;
    }

    static String reverse(String s) {

        char[] arr = s.toCharArray();
        int k = arr.length;
        int mid = arr.length / 2;


        for (int i = k - 1, j = 0; i >= mid; i--, j++) {
            swap(arr, i, j);
        }
        return new StringBuilder().append(arr).toString();
    }

    static boolean isPalindrome(String s) {
        String word = s.trim();
        int mid = word.length() / 2;
        for (int i = word.length() - 1, j = 0; i >= mid; i--, j++) {
            if (word.charAt(i) != word.charAt(j))
                return false;
        }


        return true;

    }


    public static void main(String[] args) {
        String data = "Malayalam".toUpperCase();
        System.out.println(reverse(data.toUpperCase()));

        int len = data.length();

        boolean match = IntStream.range(0, len).allMatch(o -> data.charAt(o) == data.charAt(len - o - 1));
        System.out.println(match);
        System.out.println(isPalindrome(data));

    }

}
