package com.practice.day01.bloomberg.number;

public class SlidingTechnique {

    static int compute(int[] nums, int n, int k) {
        if (n < k)
            return -1;

        int max = 0;
        for (int i = 0; i < k; i++)
            max += nums[i];

        int tmpMax = max;
        for (int i = k; i < n; i++) {
            tmpMax += nums[i] - nums[i - k];
            max = Math.max(max, tmpMax);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = {1, 4, 2, 10, 2, 3, 1, 0, 20};
        int k = 4;
        int n = arr.length;
        System.out.println(compute(arr, n, k));

        int[] nums = {5, 2, -1, 0, 3};
        k = 3;
        n = nums.length;
        System.out.println(compute(nums, n, k));
    }
}
