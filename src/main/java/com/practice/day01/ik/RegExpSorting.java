package com.practice.day01.ik;

public class RegExpSorting {

    static boolean isMatchDP(char[] text, char[] pattern) {
        boolean[][] T = new boolean[text.length + 1][pattern.length + 1];
        T[0][0] = true;

        //a* or a*b*c*
        for (int i = 1; i < T[0].length; i++) {
            if (pattern[i - 1] == '*')
                T[0][i] = T[0][i - 2];
        }

        for (int i = 1; i < T.length; i++) {
            for (int j = 1; j < T[0].length; j++) {
                if (text[i - 1] == pattern[j - 1] || pattern[j - 1] == '.')
                    T[i][j] = T[i - 1][j - 1];
                else if (pattern[j - 1] == '*') {
                    T[i][j] = T[i][j - 2];
                    if (text[i - 1] == pattern[j - 2] || pattern[j - 2] == '.') {
                        T[i][j] = T[i][j] || T[i - 1][j];
                    }
                } else
                    T[i][j] = false;
            }
        }
        return T[text.length][pattern.length];
    }


    static boolean isMatch(String s, String p) {
        boolean[][] result = new boolean[s.length() + 1][p.length() + 1];
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

    public static void main(String[] args) {
        String s = "mississippi";
        String p = "mis*is*p*";
       /* System.out.println(isMatchDP(s.toCharArray(), p.toCharArray()));
        System.out.println(isMatch(s, p));
        System.out.println("------------------------------------");
        s = "ab";
        p = "a*b*c*";
        System.out.println(isMatchDP(s.toCharArray(), p.toCharArray()));
        System.out.println(isMatch(s, p));
        System.out.println("------------------------------------");
        s = "aab";
        p = "c*a*b";
        System.out.println(isMatchDP(s.toCharArray(), p.toCharArray()));
        System.out.println(isMatch(s, p));*/

        s = "";
        p = "";
        System.out.println(isMatchDP(s.toCharArray(), p.toCharArray()));
        System.out.println(isMatch(s, p));


    }

}
