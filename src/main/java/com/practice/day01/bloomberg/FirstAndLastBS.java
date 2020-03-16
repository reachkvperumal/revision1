package com.practice.day01.bloomberg;

import java.util.Arrays;

public class FirstAndLastBS {

    static int[] binarSearch(int[] nums, int target) {
        int start = 0, end = nums.length - 1, first = -1;
        while (start <= end) {
            // int mid = start + (end - start) / 2;
            int mid = (start + end) >>> 1;
            System.out.println(mid + " -  " + start + (end - start) / 2);
            if (nums[mid] == target) {
                first = mid;
                break;
            }

            if (nums[mid] < target)
                start = mid + 1;
            else
                end = mid - 1;
        }

        if (first != -1) {
            for (start = first; start > 0 && nums[start - 1] == target; start--) ;
            for (end = first; end < nums.length - 1 && nums[end + 1] == target; end++) ;
            return new int[]{first, end};
        }

        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 8, 10, 11};
        System.out.println(Arrays.toString(binarSearch(nums, 7)));
    }
}
