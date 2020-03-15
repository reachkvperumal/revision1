package com.practice.day01.bloomberg;

public class MissingInteger {

    static int findMissingInt(int[] nums) {
        int n = nums.length;

        int count = 0;

        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) {
                count++;
                break;
            }
        }

        if (count == 0)
            return 1;

        if (n == 1)
            return 2;

        for (int i = 0; i < n; i++) {
            if (nums[i] <= 0 || nums[i] > n)
                nums[i] = 1;
        }

        for (int i = 0; i < n; i++) {
            int a = Math.abs(nums[i]);
            if (a == n)
                nums[0] = -Math.abs(nums[0]);
            else
                nums[a] = -Math.abs(nums[a]);
        }

        for (int i = 1; i < n; i++) {
            if (nums[i] > 0)
                return i;
        }

        if (nums[0] > 0)
            return n;

        return n + 1;
    }

    public static void main(String[] args) {
        int[] i = {1};
        System.out.println(findMissingInt(i));
        int[] j = {Integer.MIN_VALUE, -99, 0, 1, 22, 23};
        System.out.println(findMissingInt(j));
    }
}
