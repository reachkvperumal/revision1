package com.practice.day01;

import java.util.Comparator;

public class customComparator<T extends Comparable<T>> implements Comparator {

    @Override
    public int compare(Object o1, Object o2) {
        return 0;
    }
}
