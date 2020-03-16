package com.practice.day01.bloomberg;

public class BinarySearch {

    static int binarySearch(int[] nums, int target) {
        int start = 0, end = nums.length - 1;

        while (start <= end) {
            //int mid = start + (end - start) / 2;
            int mid = (start + end) >>> 1;

            if (nums[mid] < target)
                start = mid + 1;
            else if (nums[mid] > target)
                end = mid - 1;
            else
                return mid;
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 8, 10, 11};
        System.out.println(binarySearch(nums, 8));
    }

}
