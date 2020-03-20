package com.practice.day01.bloomberg;

public class LongestPalindromicSubsequence {

    static int compute(String str) {
        int n = str.length();
        int[][] aux = new int[n][n];

        for (int i = 0; i < n; i++)
            aux[i][i] = 1;

        for (int k = 2; k <= n; k++) {
            for (int i = 0; i < n - k + 1; i++) {
                int j = i + k - 1;
                boolean isValid = str.charAt(i) == str.charAt(j);
                if (k == 2 && isValid)
                    aux[i][j] = 2;
                else if (isValid)
                    aux[i][j] = aux[i + 1][j - 1] + 2;
                else
                    aux[i][j] = Math.max(aux[i][j - 1], aux[i + 1][j]);
            }
        }
        return aux[0][n - 1];
    }

    public static void main(String[] args) {
        System.out.println(compute("agbdba"));
        System.out.println("".length());
    }
}
