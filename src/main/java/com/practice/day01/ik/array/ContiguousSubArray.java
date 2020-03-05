package com.practice.day01.ik.array;

public class ContiguousSubArray {

    static int findMaxLength(int[] nums) {
        int max = nums[0];
        int cur = max;

        for (int i = 1; i < nums.length; i++) {
            cur = Math.max(nums[i], nums[i] + cur);
            max = Math.max(max, cur);
        }

        return max;
    }

    public static void main(String[] args) {
        int[] i = {-42, -33, -14, -21, -12, -91, -35, -23};
        System.out.println(findMaxLength(i));
    }
}
