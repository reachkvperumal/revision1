package com.practice.day01.bloomberg;

public class KMP {

    static int[] compute(char[] pattern) {
        int n = pattern.length, index = 0;
        int[] lps = new int[n];
        for (int i = 1; i < n; ) {
            if (pattern[i] == pattern[index])
                lps[i++] = ++index;
            else if (index > 0)
                index = lps[index - 1];
            else
                lps[i++] = 0;
        }
        return lps;
    }

    static boolean compute(char[] text, char[] pattern) {
        int[] lps = compute(pattern);
        int i = 0, j = 0;

        while (i < text.length && j < pattern.length) {
            if (text[i] == pattern[j]) {
                i++;
                j++;
            } else {
                if (j > 0)
                    j = lps[j - 1];
                else
                    i++;
            }
        }
        if (pattern.length == j) {
            System.out.printf("Index Position : %d%n", i - j);
            return true;
        } else
            return false;
    }

    public static void main(String[] args) {
        String text = "ABABDABACDABABCABAB";
        String pattern = "ABABCABAB";
        System.out.println(compute(text.toCharArray(), pattern.toCharArray()));
    }
}
