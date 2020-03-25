package com.practice.day01.bloomberg.word;

import java.util.HashMap;
import java.util.Map;

public class Anagram {

    static boolean isAnagramHP(String s, String t) {
        Map<Character, Integer> hashMap = new HashMap<>();

        for (char c : s.toCharArray())
            hashMap.put(c, hashMap.getOrDefault(c, 0) + 1);

        for (char c : t.toCharArray())
            hashMap.put(c, hashMap.getOrDefault(c, 0) - 1);

        for (char c : hashMap.keySet()) {
            if (hashMap.get(c) != 0) {
                return false;
            }
        }
        return true;
    }

    static boolean isAnagram(String s, String t) {
        int s1 = s.length();
        int s2 = t.length();

        if (s1 != s2)
            return false;

        int[] counter = new int[128];
        for (int i = 0; i < s1; i++) {
            counter[s.charAt(i) - 'a']++;
            counter[t.charAt(i) - 'a']--;
        }

        for (int i : counter) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isAnagram("anagram", "nagaram"));
        System.out.println(isAnagramHP("anagram", "nagaram"));

    }
}
