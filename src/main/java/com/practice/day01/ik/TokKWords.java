package com.practice.day01.ik;

import java.util.*;
import java.util.stream.Collectors;

public class TokKWords {

    private static class Pair implements Comparable<Pair> {

        private String word;
        private int frequency;

        public Pair(String word, int count) {
            this.word = word;
            this.frequency = count;
        }

        @Override
        public int compareTo(Pair o) {
            if (this.frequency == o.frequency)
                return o.word.compareTo(this.word);
            else
                return Integer.compare(this.frequency, o.frequency);
        }
    }


    static List<String> topKwords(String[] words, int count) {

        Map<String, Integer> map = new HashMap<>();
       /* for (String key : words) {
            map.computeIfPresent(key, (k, v) -> v + 1);
            map.computeIfAbsent(key, v -> 1);
        }*/
        for (String key : words)
            map.put(key, map.getOrDefault(key, 0) + 1);

        PriorityQueue<Pair> pairs = map.entrySet()
                .stream().map(k -> new Pair(k.getKey(), k.getValue()))
                .collect(Collectors.toCollection(PriorityQueue::new));


        return pairs.stream().sorted(Comparator.reverseOrder()).limit(count).map(o -> o.word).collect(Collectors.toList());


    }

    public static void main(String[] args) {
        //[the, is, sunny, day]
        //[i, love]
        String[] words1 = {"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};
        System.out.println(topKwords(words1, 4));
        String[] words2 = {"i", "love", "leetcode", "i", "love", "coding"};
        System.out.println(topKwords(words2, 2));

    }
}
