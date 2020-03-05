package com.practice.day01;

import java.util.Comparator;

public class customComparator<T extends Comparable<T>> implements Comparator {

    @Override
    public int compare(Object o1, Object o2) {
        return 0;
    }

    public static void main(String[] args) {
        int[] items = {1, 2, 3, 4};

        for (int i = 0; i < items.length; i++) {
            for (int j = i; j < items.length; j++) {
                for (int k = i; k <= j; k++) {
                    System.out.print(items[k]);
                }
                System.out.println();
            }
        }
    }
}
