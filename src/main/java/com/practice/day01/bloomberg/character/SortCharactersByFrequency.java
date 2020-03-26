package com.practice.day01.bloomberg.character;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SortCharactersByFrequency {

    static String sort(String s) {
        if (s == null || s.length() == 0)
            return s;

        Map<Character, Integer> counts = s.chars().mapToObj(c -> (char) c).collect(Collectors.toMap(k -> k, v -> 1, Integer::sum));

        int max = Collections.max(counts.values());

        List<List<Character>> buckets = new ArrayList<>();
        for (int i = 0; i <= max; i++)
            buckets.add(new ArrayList<>());

        for (char c : counts.keySet())
            buckets.get(counts.get(c)).add(c);

        StringBuilder sb = new StringBuilder();

        for (int i = max; i > 0; i--) {
            for (char c : buckets.get(i)) {
                for (int j = 0; j < i; j++)
                    sb.append(c);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {

        System.out.println(sort("tree"));
    }
}
