package com.practice.day01.bloomberg;

import java.util.Arrays;
import java.util.List;

public class WordBreak2DP {

    static List<String> wordBreak(String s, List<String> dic) {

        int n = s.length();
        int[][] aux = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < aux[i].length; j++) {
                aux[i][j] = -1;
            }
        }

        //fill up the matrix
        for (int l = 1; l <= n; l++) {
            for (int i = 0; i < n - l + 1; i++) {
                int j = i + l - 1;
                String str = s.substring(i, j + 1);
                if (dic.contains(str)) {
                    aux[i][j] = i;
                    continue;
                }
                //find a k between i+1 to j such that T[i][k-1] && T[k][j] are both true
                for (int k = i + 1; k <= j; k++) {
                    if (aux[i][k - 1] != -1 && aux[k][j] != -1) {
                        aux[i][j] = k;
                        break;
                    }
                }
            }
        }

        if (aux[0][n - 1] == -1)
            return null;

        StringBuffer buffer = new StringBuffer();
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            int k = aux[i][j];
            if (i == k) {
                buffer.append(s.substring(i, j + 1));
                break;
            }
            buffer.append(s.substring(i, k) + " ");
            i = k;
        }
        System.out.println(buffer);
        return Arrays.asList(buffer.toString());
    }

    public static void main(String[] args) {
        String s = "catsanddog";
        List<String> dict = Arrays.asList("cat", "cats", "and", "sand", "dog");
        System.out.println(wordBreak(s, dict));
    }
}
