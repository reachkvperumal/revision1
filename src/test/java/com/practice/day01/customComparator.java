package com.practice.day01;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class customComparator<T extends Comparable<T>> implements Comparator {

    @Override
    public int compare(Object o1, Object o2) {
        return 0;
    }

    public static void main(String[] args) {
        int[] items = {1, 2, 3, 4};
        List<Integer> list = Arrays.stream(items).boxed().collect(Collectors.toList());
        System.out.println(list.get(3 - 1));
    }
}
