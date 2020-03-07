package com.practice.day01.ik;


import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class MergeOverlappingIntervals {

    private static class Interval {
        private final int start;
        private final int end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public Interval(int[] arr) {
            this.start = arr[0];
            this.end = arr[1];
        }

        public int getStart() {
            return start;
        }

        public int getEnd() {
            return end;
        }
    }

    static int[][] getOverlap(Interval[] arr) {
        int[][] result = null;
        Arrays.sort(arr, (i1, i2) -> i1.getStart() - i2.getStart());
        Deque<Interval> deque = new ArrayDeque<>();
        deque.offerFirst(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            Interval first = deque.peekFirst();
            Interval current = arr[i];
            if (first.getEnd() < current.getStart())
                deque.offerFirst(current);
            else if (first.getEnd() < current.getEnd()) {
                deque.removeFirst();
                deque.offerFirst(new Interval(first.getStart(), current.getEnd()));
            }
        }

        result = new int[deque.size()][2];
        int count = 0;
        while (!deque.isEmpty()) {
            Interval last = deque.removeLast();
            result[count++] = new int[]{last.getStart(), last.getEnd()};
        }

        return result;
    }


    public static void main(String[] args) {
        int[][] arr = {{1, 3}, {5, 7}, {2, 4}, {6, 8}};
        //int size = arr.length;

        Interval[] intervals = Arrays.stream(arr).map(Interval::new).toArray(Interval[]::new);

        /*Interval[] intervals = new Interval[size];
        for (int i = 0; i < arr.length; i++)
            intervals[i] = new Interval(arr[i]);*/

        int[][] overlap = getOverlap(intervals);
        for (int i = 0; i < overlap.length; i++)
            System.out.println(Arrays.toString(overlap[i]));
    }

}
