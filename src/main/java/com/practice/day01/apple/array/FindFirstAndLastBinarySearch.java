package com.practice.day01.apple.array;

import java.util.Arrays;

public class FindFirstAndLastBinarySearch {

  static int[] find(int[] nums, int target) {

    int pos = nums.length, start = 0, end = pos - 1, first = -1;

    while (start <= end) {
      int mid = (start + end) >>> 1;

      if (nums[mid] == target) {
        first = mid;
        break;
      }

      if (nums[mid] < target) {
        start = mid + 1;
      } else {
        end = mid - 1;
      }
    }

    if (first > -1) {
      for (start = first; start > 0 && nums[start - 1] == target; start--) {
        ;
      }
      for (end = first; end < pos - 1 && nums[end + 1] == target; end++) {
        ;
      }
      return new int[]{start, end};
    }
    return new int[]{-1, -1};
  }

  public static void main(String[] args) {
    int[] nums = {5, 7, 7, 8, 8, 10};
    System.out.println(Arrays.toString(find(nums, 8)));
  }

}
