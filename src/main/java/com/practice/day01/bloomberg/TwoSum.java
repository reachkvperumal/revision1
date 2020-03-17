package com.practice.day01.bloomberg;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    static int[] compute(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int c = target - nums[i];
            if (map.containsKey(c)) {
                return new int[]{map.get(c), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        int[] nums = {11, 15, 2, 7, 9};
        System.out.println(Arrays.toString(compute(nums, 9)));
    }
}
