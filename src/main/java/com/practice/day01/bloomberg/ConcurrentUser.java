package com.practice.day01.bloomberg;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class ConcurrentUser {

    private static class Duration implements Comparable<Duration> {
        private int start;
        private int end;

        public Duration(int s, int e) {
            this.start = s;
            this.end = e;
        }

        @Override
        public int compareTo(Duration o) {
            return Integer.compare(this.start, o.start);
        }
    }

    static void compute(List<Duration> durations) {
        Collections.sort(durations);

        PriorityQueue<Integer> endTime = new PriorityQueue<>();

        int maxConc = 0, maxConcRunning = 0;

        for (Duration duration : durations) {
            if (endTime.isEmpty() || duration.start <= endTime.peek()) {
                maxConc++;
                maxConcRunning = maxConc;
            } else {
                endTime.poll();
                maxConcRunning--;
            }

            endTime.offer(duration.end);
        }
        System.out.println("Max concurrent User :" + maxConc);
    }

    public static void main(String[] args) {
        int[][] time = {{1, 10}, {2, 11}, {3, 12}, {9, 13}, {11, 14}};

        List<Duration> collect = Arrays.stream(time).map(o -> new Duration(o[0], o[1])).collect(Collectors.toList());
        compute(collect);
    }
}
