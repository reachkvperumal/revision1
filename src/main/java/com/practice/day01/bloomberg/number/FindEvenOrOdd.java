package com.practice.day01.bloomberg.number;

import java.util.stream.IntStream;

public class FindEvenOrOdd {

    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 3, 4, 5, 6};
        IntStream.of(nums).forEach(i -> System.out.println((i & 0x1) == 1));
        System.out.println(~3);
        System.out.println(~-4);
        int i = 10;
        System.out.println(i % 2);
        System.out.println(i & 0x1);
    }
}
