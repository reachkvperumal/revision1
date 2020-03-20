package com.practice.day01.bloomberg;

public class LongestPalindrome {

    static String longest(String s) {
        if (s == null || s.length() == 0)
            return s;

        int n = s.length();
        String ans = "";
        int max = 0;
        boolean[][] aux = new boolean[n][n];

        for (int j = 0; j < n; j++) {
            for (int i = 0; i <= j; i++) {
                boolean isValid = s.charAt(i) == s.charAt(j);
                aux[i][j] = j - i > 2 ? aux[i + 1][j - 1] && isValid : isValid;
                if (aux[i][j] && j - i + 1 > max) {
                    max = j - i + 1;
                    ans = s.substring(i, j + 1);
                }

            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(longest("cbbd"));
    }
}
