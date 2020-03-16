package com.practice.day01.bloomberg;

import java.util.ArrayDeque;
import java.util.Deque;

public class MaximiumRectangle {

    static int largest(int[] heights) {
        int k = heights.length;
        int count = 0, max = Integer.MIN_VALUE;
        Deque<Integer> deque = new ArrayDeque<>();

        while (count < k) {
            if (deque.isEmpty() || heights[count] >= heights[deque.peek()])
                deque.offerFirst(count++);
            else
                max = Math.max(max, heights[deque.removeFirst()] * (deque.isEmpty() ? count : count - 1 - deque.peek()));
        }

        while (!deque.isEmpty())
            max = Math.max(max, heights[deque.removeFirst()] * (deque.isEmpty() ? count : count - 1 - deque.peek()));

        return max;
    }

    static int maximalRectangle(char[][] matrix) {
        int k = matrix.length;
        if (k == 0)
            return 0;
        int max = Integer.MIN_VALUE;

        int dp[] = new int[matrix[0].length];
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                dp[j] = matrix[i][j] == '1' ? dp[j] + 1 : 0;
            }
            max = Math.max(max, largest(dp));
        }
        return max;
    }

    public static void main(String[] args) {
        char[][] input = {
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}
        };

        System.out.println(maximalRectangle(input));
    }
}
