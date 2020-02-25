package com.practice.day01.ik;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Lexicographical {

    private static class Entry {
        private int count;
        private String lexVal;

        public Entry(String lexVal) {
            this.count++;
            this.lexVal = lexVal;
        }
    }

    static String[] execute(String[] arr) {
        Map<String, Entry> map = new HashMap<>();

        for (String s : arr) {
            String[] split = s.split(" ");
            String key = split[0];
            String value = split[1];
            map.computeIfPresent(key, (k, v) -> {
                v.count++;
                if (v.lexVal.compareTo(value) < 0)
                    v.lexVal = value;
                return v;
            });
            map.computeIfAbsent(key, k -> new Entry(value));
        }

        return map.entrySet().stream()
                .map((k) -> String.format("%s:%d,%s", k.getKey(), k.getValue().count, k.getValue().lexVal))
                .toArray(String[]::new);
    }

    public static void main(String[] args) {
        String[] arr = {"key1 abcd", "key2 zzz", "key1 hello", "key3 world", "key1 hello"};
        System.out.println(Arrays.toString(execute(arr)));
    }

}
