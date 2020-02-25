package com.practice.day01.ik;

import java.util.ArrayDeque;
import java.util.Deque;

public class AreaOfHistogram {
    static int largestRectangleArea(int[] heights) {

        if (heights == null || heights.length < 1)
            return 0;

        if (heights.length == 1)
            return heights[0];

        int max = Integer.MIN_VALUE;
        int k = heights.length;
        int count = 0;
        Deque<Integer> deque = new ArrayDeque<>();

        while (count < k) {
            if (deque.isEmpty() || heights[count] >= heights[deque.peek()])
                deque.offer(count++);
            else
                max = Math.max(max, heights[deque.pop()] * (deque.isEmpty() ? count : count - 1 - deque.peek()));
        }

        while (!deque.isEmpty())
            max = Math.max(max, heights[deque.pop()] * (deque.isEmpty() ? count : count - 1 - deque.peek()));

        return max;
    }

    public static void main(String[] args) {
        int[] input = {2, 1, 5, 6, 2, 3};
        System.out.println(largestRectangleArea(input));
    }
}
