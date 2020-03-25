package com.practice.day01.bloomberg.word;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class SplitWordCount {

    private static class WordCount implements Comparable<WordCount> {
        private final String word;
        private final int count;

        public WordCount(String word, int count) {
            this.word = word;
            this.count = count;
        }

        @Override
        public String toString() {
            return String.format("word = %s, count = %d", this.word, this.count);
        }

        public int compareTo(WordCount o) {
            return this.count - o.count;
        }

    }

    private static class TopOccurrence {
        private final PriorityQueue<WordCount> minHeap;
        private final int maxSize;

        public TopOccurrence(int maxSize) {
            this.maxSize = maxSize;
            this.minHeap = new PriorityQueue<>();
        }

        public void add(WordCount data) {
            if (minHeap.size() < maxSize) {
                minHeap.offer(data);
            } else if (minHeap.poll().count < data.count) {
                minHeap.poll();
                minHeap.offer(data);
            }
        }

        @Override
        public String toString() {
            return String.format("TopOccurrence{ minHeap = %s, maxSize = %d", this.minHeap, this.maxSize);
        }

        public static void main(String[] args) {
            List<String> terms = Arrays.asList("Coding is great", "Search Engine are great",
                    "Google is a nice search engine", "bing is also a nice engine");
            TopOccurrence topOccurrence = new TopOccurrence(2);
            terms.parallelStream().flatMap(s -> Arrays.asList(s.split(" ")).stream())
                    .collect(Collectors.toConcurrentMap(w -> w.toLowerCase(), w -> 1, Integer::sum))
                    .forEach((s, i) -> {
                        topOccurrence.add(new WordCount(s, i));
                    });

            System.out.println(topOccurrence);

            TopOccurrence topOccurrence1 = new TopOccurrence(2);
            terms.stream().flatMap(o -> Arrays.asList(o.split(" ")).stream())
                    .collect(Collectors.toMap(w -> w.toLowerCase(), w -> 1, Integer::sum))
                    .forEach((w, i) -> topOccurrence1.add(new WordCount(w, i)));
            System.out.println(topOccurrence1);

        }
    }


}
