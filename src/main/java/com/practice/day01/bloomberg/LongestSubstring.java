package com.practice.day01.bloomberg;

import java.util.HashSet;

public class LongestSubstring {

    static int computeN(String s) {
        int n = s.length(), max = 0;
        int[] aux = new int[128];
        for (int i = 0, j = 0; j < n; j++) {
            char c = s.charAt(j);
            i = Math.max(i, aux[c]);
            max = Math.max(max, j - i + 1);
            aux[c] = j + 1;
        }
        return max;
    }

    static int compute(String s) {
        if (s == null || s.length() == 0)
            return 0;

        HashSet<Character> set = new HashSet<>();

        int j = 0, max = Integer.MIN_VALUE;

        while (j < s.length()) {
            char c = s.charAt(j);
            if (!set.contains(c)) {
                set.add(c);
                j++;
                max = Math.max(max, set.size());
            } else {
                set.remove(c);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        String s = "abcbacbb";
        System.out.println(compute(s));
        System.out.println(computeN(s));
    }
}
