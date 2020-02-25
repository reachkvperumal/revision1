package com.practice.day01.ik;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class MaxRectangle {

    static int largest(int[] arr) {
        int k = arr.length;
        int max = Integer.MIN_VALUE;
        int count = 0;
        Deque<Integer> deque = new ArrayDeque<>();

        while (count < k) {
            if (deque.isEmpty() || arr[count] >= arr[deque.peek()])
                deque.push(count++);
            else
                max = Math.max(max, arr[deque.pop()] * (deque.isEmpty() ? count : count - 1 - deque.peek()));
        }

        while (!deque.isEmpty())
            max = Math.max(max, arr[deque.pop()] * (deque.isEmpty() ? count : count - 1 - deque.peek()));

        return max;
    }

    static int maxRectangle(char[][] matrix) {
        int k = matrix.length;
        if (matrix == null || k == 0) return 0;
        int max = Integer.MIN_VALUE;
        int[] dp = new int[matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++)
                dp[j] = matrix[i][j] == '1' ? dp[j] + 1 : 0;
            System.out.println(Arrays.toString(dp));
            max = Math.max(max, largest(dp));
        }

        return max;
    }

    public static void main(String[] args) {
        char[][] input = {{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}};
        System.out.println(maxRectangle(input));
    }
}
