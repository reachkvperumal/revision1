package com.practice.day01.ik;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class TopK {

    private static int[] reverseTopK(int[] arr, int k) {
        Set<Integer> set = new TreeSet<>((o1, o2) -> {
            int result = 0;
            if (o1 < o2)
                result = 1;
            else if (o1 > o2)
                result = -1;
            return result;
        });
        for (int i : arr) {
            set.add(i);
            if (set.size() > k)
                ((TreeSet) set).pollFirst();
        }
        return set.stream().sorted(Integer::compare).mapToInt(Integer::intValue).toArray();
    }

    private static int[] topK(int[] arr, int k) {
        Set<Integer> set = new TreeSet<>();
        for (int a : arr) {
            set.add(a);
            if (set.size() > k)
                ((TreeSet) set).pollFirst();
        }
        return set.stream().mapToInt(Integer::intValue).toArray();
    }


    public static void main(String[] args) {
        int[] arr = {5, 6, 1, 4, 1, 8, 2, 4, 1, 7, 9, 3, 2, 1};

        int k = 2;
        System.out.println(Arrays.toString(reverseTopK(arr, k)));
        System.out.println(Arrays.toString(topK(arr, k)));
    }

}
