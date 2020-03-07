package com.practice.day01.ik;

public class RegExpSort {

    static boolean isMatch(String s, String p) {
        boolean[][] T = new boolean[s.length() + 1][p.length() + 1];
        T[s.length()][p.length()] = true;

        for (int i = s.length(); i >= 0; i--) {
            for (int j = p.length() - 1; j >= 0; j--) {
                boolean anyMatch = i < s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');
                if (j + 1 < p.length() && p.charAt(j + 1) == '*')
                    T[i][j] = T[i][j + 2] || (anyMatch && T[i + 1][j]);
                else
                    T[i][j] = anyMatch && T[i + 1][j + 1];
            }
        }
        return T[0][0];
    }

    public static void main(String[] args) {
        String s = "mississippi";
        String p = "mis*is*p*";
        System.out.println(isMatch(s, p));
        System.out.println("------------------------------------");
        s = "ab";
        p = "a*b*c*";
        System.out.println(isMatch(s, p));
        System.out.println("------------------------------------");
        s = "aab";
        p = "c*a*b";
        System.out.println(isMatch(s, p));

        s = "";
        p = "";
        System.out.println(isMatch(s, p));
    }
}
