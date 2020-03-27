package com.practice.day01.bloomberg.number.find;

public class FindElementSortedRotatedArray {

    static int search(int[] nums, int target) {

        if (nums == null || nums.length == 0)
            return -1;

        int size = nums.length;
        int start = 0, end = size - 1;

        while (start <= end) {
            int mid = (start + end) >>> 1;
            if (nums[mid] == target)
                return mid;
            else if (nums[mid] >= nums[start]) {
                if (target >= nums[start] && target < nums[mid])
                    end = mid - 1;
                else
                    start = mid + 1;
            } else {
                if (target <= nums[end] && target > nums[mid])
                    start = mid + 1;
                else
                    end = mid - 1;
            }
        }


        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int pos = search(nums, 0);
        System.out.println(nums[pos]);
    }
}
