package com.practice.day01.bloomberg.number.find;

public class MissingNumber {

    static int findMissing(int[] nums) {
        int missingNum = nums.length;

        for (int i = 0; i < nums.length; i++)
            missingNum ^= i ^ nums[i];

        return missingNum;
    }

    public static void main(String[] args) {
        int[] nums = {0, 2, 3, 4};
        System.out.println(findMissing(nums));
    }
}
