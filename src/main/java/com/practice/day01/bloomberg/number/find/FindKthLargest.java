package com.practice.day01.bloomberg.number.find;

import java.util.PriorityQueue;

public class FindKthLargest {

    static int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(n);

        for (int i : nums) {
            maxHeap.offer(i);
            if (maxHeap.size() > k)
                maxHeap.poll();
        }

        return maxHeap.poll();
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 5, 6, 4};
        System.out.println(findKthLargest(nums, 2));
    }
}
