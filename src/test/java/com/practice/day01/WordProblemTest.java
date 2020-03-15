package com.practice.day01;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class WordProblemTest {

    public List<Integer> findSubstring(String S, String[] L) {
        List<Integer> result = new ArrayList<>();
        if (S == null || S.length() == 0 || L == null || L.length == 0) {
            return result;
        }

        int m = L[0].length();
        Map<String, Integer> map = new HashMap<>();
        for (String str : L) {
            if (map.containsKey(str)) {
                int count = map.get(str) + 1;
                map.put(str, count);
            } else {
                map.put(str, 1);
            }
        }

        for (int start = 0; start < S.length(); start++) {
            if (S.length() - start < (L.length * m)) {
                break;
            }

            Map<String, Integer> curMap = new HashMap<String, Integer>(map);
            for (int end = start; end < S.length(); end += m) {
                if (S.length() - end < (curMap.size() * m)) {
                    break;
                }
                String token = S.substring(end, end + m);
                if (curMap.containsKey(token)) {
                    int count = curMap.get(token);
                    if (count == 1) {
                        curMap.remove(token);
                    } else {
                        count--;
                        curMap.put(token, count);
                    }
                } else {
                    break;
                }
                if (curMap.isEmpty()) {
                    result.add(start);
                    break;
                }
            }
        }
        return result;
    }


    private static class Words implements Comparable<Words> {

        private String word;
        private int frequency;

        public Words(String w, int frequence) {
            this.word = w;
            this.frequency = frequence;
        }

        @Override
        public int compareTo(Words o) {
            if (this.frequency == o.frequency)
                return o.word.compareTo(this.word);
            else
                return Integer.compare(this.frequency, o.frequency);

        }


    }

    @Test
    public void testMap() {
        String[] s = {"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};
        int k = 4;
        List<String> wordsList = Arrays
                .stream(s)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().map(o -> new Words(o.getKey(), o.getValue().intValue()))
                .collect(Collectors.toCollection(PriorityQueue::new)).stream().limit(k).sorted(Comparator.reverseOrder())
                .map(o -> o.word).collect(Collectors.toList());

        System.out.println(wordsList);

    }

    @Test
    public void reverseNumberTest() {
        int i = 0x7ffffff;
        System.out.println(i);

        int cur = 0;
        while (i > 0) {
            cur = cur * 10 + i % 10;
            i /= 10;
        }
        System.out.println(cur);

        char c = 'z';
        System.out.println(c - 'a');
    }



}
