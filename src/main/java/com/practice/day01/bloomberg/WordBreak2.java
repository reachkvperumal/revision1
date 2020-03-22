package com.practice.day01.bloomberg;

import java.util.*;

public class WordBreak2 {

    static List<String> wordBreakWIthMemory(String s, List<String> wordDict) {
        int n = s.length();

        LinkedList<String>[] dp = new LinkedList[n + 1];
        LinkedList<String> init = new LinkedList<>();
        init.add("");
        dp[0] = init;

        for (int i = 1; i <= n; i++) {
            LinkedList<String> current = new LinkedList<>();
            for (int j = 0; j < i; j++) {
                if (dp[j].size() > 0 && wordDict.contains(s.substring(j, i))) {
                    for (String s1 : dp[j])
                        current.add(s1 + (s1.equals("") ? "" : " ") + s.substring(j, i));
                }
            }
            dp[i] = current;
        }
        return dp[n];
    }

    static List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);

        // Check if there is at least one possible sentence
        boolean[] dp1 = new boolean[s.length() + 1];
        dp1[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp1[j] && wordSet.contains(s.substring(j, i))) {
                    dp1[i] = true;
                    break;
                }
            }
        }

        // We are done if there isn't a valid sentence at all
        if (!dp1[s.length()]) {
            return new ArrayList<String>();
        }

        // Build the results with dynamic programming
        LinkedList<String>[] dp = new LinkedList[s.length() + 1];
        LinkedList<String> initial = new LinkedList<>();
        initial.add("");
        dp[0] = initial;
        for (int i = 1; i <= s.length(); i++) {
            LinkedList<String> list = new LinkedList<>();
            for (int j = 0; j < i; j++) {
                if (dp[j].size() > 0 && wordSet.contains(s.substring(j, i))) {
                    for (String l : dp[j]) {
                        list.add(l + (l.equals("") ? "" : " ") + s.substring(j, i));
                    }
                }
            }
            dp[i] = list;
        }
        System.out.println(dp[s.length()].toString());
        return dp[s.length()];
    }

    public static void main(String[] args) {
        String s = "abcd";
        List<String> dict = Arrays.asList("a", "abc", "b", "cd");
        System.out.println(wordBreak(s, dict));
    }
}
