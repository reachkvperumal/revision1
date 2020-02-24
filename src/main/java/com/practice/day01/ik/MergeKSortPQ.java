package com.practice.day01.ik;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class MergeKSortPQ {

    private static class HeapEntry implements Comparable<HeapEntry> {

        private int value;
        private int row;
        private int col;

        public HeapEntry(int value, int row, int col) {
            this.value = value;
            this.row = row;
            this.col = col;
        }

        @Override
        public int compareTo(HeapEntry o) {
            int result = 0;
            if (this.value < o.value)
                result = -1;
            else if (this.value > o.value)
                result = 1;
            return result;
        }
    }

    static boolean isMinHeap(int[][] arr, int k, int n) {
        for (int i = 0; i < k; i++) {
            int[] ints = arr[i];
            if (ints.length > 1) {
                if (ints[0] > ints[n - 1])
                    return false;
                else if (ints[0] < ints[n - 1])
                    break;
            }
        }
        return true;
    }

    static int[] mergeArrays(int[][] arr) {
        int k = arr.length;
        int n = arr[0].length;

        if (k < 2)
            return null;
        Queue<HeapEntry> queue;
        if (isMinHeap(arr, k, n))
            queue = new PriorityQueue<>(k);
        else
            queue = new PriorityQueue<>(k, Comparator.reverseOrder());

        for (int i = 0; i < k; i++)
            queue.offer(new HeapEntry(arr[i][0], i, 0));

        int[] result = new int[k * n];
        int count = 0;
        while (!queue.isEmpty()) {
            HeapEntry poll = queue.poll();
            result[count++] = poll.value;
            if (poll.col < n - 1)
                queue.offer(new HeapEntry(arr[poll.row][poll.col + 1], poll.row, poll.col + 1));
        }

        return result;
    }


    public static void main(String[] args) {
        int arr[][] = {{34, 26, 20, 13, 11, 7, 4, 4}, {41, 34, 27, 23, 19, 10, 8, 0}, {26, 25, 19, 12, 7, 7, 7, 5},
                {46, 39, 35, 33, 27, 19, 12, 9}, {33, 24, 22, 18, 18, 10, 3, 0}, {42, 35, 35, 30, 21, 20, 12, 9}, {42, 33, 24, 21, 12, 12, 8, 7},
                {29, 23, 21, 18, 18, 11, 8, 7}, {35, 30, 30, 23, 15, 14, 8, 7}, {20, 18, 17, 16, 12, 11, 5, 4}
        };
        System.out.println(Arrays.toString(mergeArrays(arr)));
    }
}
