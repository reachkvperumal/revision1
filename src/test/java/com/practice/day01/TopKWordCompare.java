package com.practice.day01;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TopKWordCompare {

    private static class Pair implements Comparable<Pair> {

        private String word;
        private int frequency;

        public Pair(String word, int frequency) {
            this.word = word;
            this.frequency = frequency;
        }

        @Override
        public int compareTo(Pair o) {
            if (this.frequency == o.frequency)
                return o.word.compareTo(this.word);
            else
                return Integer.compare(this.frequency, o.frequency);

        }
    }


    public static List<String> topKFrequent(String[] words, int k) {

        Map<String, Long> map = Arrays.stream(words).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        PriorityQueue<Pair> queue = map.entrySet().stream().map(o -> new Pair(o.getKey(), o.getValue().intValue()))
                .collect(Collectors.toCollection(PriorityQueue::new));

        return queue.stream().sorted(Comparator.reverseOrder()).limit(k).map(o -> o.word).collect(Collectors.toList());
    }

    public static void main(String[] args) {
        String[] arr = {"i", "love", "leetcode", "i", "love", "coding"};
        System.out.println(topKFrequent(arr, 2));
        int pos = (int) Math.pow(2, 32) / 8;
        System.out.println(pos);
    }
}
