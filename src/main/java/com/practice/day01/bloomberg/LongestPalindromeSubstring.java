package com.practice.day01.bloomberg;

public class LongestPalindromeSubstring {

    static String compute(String s) {
        if (s == null || s.length() == 0)
            return null;
        int n = s.length(), max = 0;
        String result = null;

        boolean[][] aux = new boolean[n][n];

        for (int j = 0; j < n; j++) {
            for (int i = 0; i <= j; i++) {
                boolean isValid = s.charAt(i) == s.charAt(j);
                aux[i][j] = j - i > 2 ? aux[i + 1][j - 1] && isValid : isValid;
                // System.out.printf("%d,%d = %b, ",j,i,aux[i][j]);
                if (aux[i][j] && j - i + 1 > max) {
                    max = j - i + 1;
                    result = s.substring(i, j + 1);
                }
            }
            System.out.println();
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(compute("cbbd"));
    }
}
