package com.practice.day01.bloomberg.number.find;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class LongestConsecutiveSequence {

    static int longestStreak(int[] nums) {
        Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toCollection(HashSet::new));

        int streak = 0;
        for (int n : set) {
            if (!set.contains(n - 1)) {
                int current = n;
                int currentStreak = 1;
                while (set.contains(current + 1)) {
                    current++;
                    currentStreak++;
                }
                streak = Math.max(streak, currentStreak);
            }
        }
        return streak;
    }

    public static void main(String[] args) {
        int[] nums = {100, 101, 102, 103, 104, 105, 106, 107, 4, 200, 1, 3, 2};
        System.out.println(longestStreak(nums));
    }
}
