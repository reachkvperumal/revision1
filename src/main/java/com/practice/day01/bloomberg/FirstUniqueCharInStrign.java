package com.practice.day01.bloomberg;

import java.util.HashMap;
import java.util.Map;

public class FirstUniqueCharInStrign {

    static int firstUniqChar(String s) {
        int k = s.length();
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < k; i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < k; i++) {
            if (map.get(s.charAt(i)) == 1)
                return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(firstUniqChar("loveleetcode"));
    }
}
