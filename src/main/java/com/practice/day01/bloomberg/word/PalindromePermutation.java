package com.practice.day01.bloomberg.word;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class PalindromePermutation {

    static boolean compute(String s) {
        Map<Character, Long> map = s.chars().mapToObj(o -> (char) o)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        int count = 0;
        for (char c : map.keySet())
            count += map.get(c).intValue() % 2;

        return count <= 1;
    }

    public static void main(String[] args) {
        System.out.println(compute("ABAB"));
    }


}
