package com.practice.day01.bloomberg.word;

public class LongestCommonSubSequence {

    static int lcs(char str1[], char str2[], int len1, int len2) {

        if (len1 == str1.length || len2 == str2.length) {
            return 0;
        }
        if (str1[len1] == str2[len2]) {
            return 1 + lcs(str1, str2, len1 + 1, len2 + 1);
        } else {
            return Math.max(lcs(str1, str2, len1 + 1, len2), lcs(str1, str2, len1, len2 + 1));
        }
    }

    static int compute(char[] str1, char[] str2) {
        int row = str1.length;
        int col = str2.length;
        int[][] aux = new int[row + 1][col + 1];

        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                if (str1[i - 1] == str2[j - 1])
                    aux[i][j] = aux[i - 1][j - 1] + 1;
                else
                    aux[i][j] = Math.max(aux[i][j - 1], aux[i - 1][j]);
            }
        }
        return aux[row][col];
    }

    public static void main(String[] args) {
        String str1 = "ABCDGHLQR";
        String str2 = "AEDPHR";
        System.out.println(compute(str1.toCharArray(), str2.toCharArray()));
        System.out.println(lcs(str1.toCharArray(), str2.toCharArray(), 0, 0));
    }
}
