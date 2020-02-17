package com.practice.day01;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BinarySort {

    static int sort(int[] input, int target) {
        int start = 0;
        int end = input.length - 1;

        while (start <= end) {
            int mid = start + ((end - start) / 2);

            if (input[mid] == target)
                return mid;
            else if (input[mid] > target)
                end = mid - 1;
            else if (input[mid] < target)
                start = mid + 1;
        }
        return -1;
    }

    static boolean isBadVersion(int i) {
        return i == 5 ? true : false;
    }

    static int getFirstBadVersion() {
        int start = 1;
        int end = 10;

        while (start <= end) {
            int mid = start + ((end - start) / 2);
            if (isBadVersion(mid))
                end = mid - 1;
            else
                start = mid + 1;
        }
        return start;
    }

    public static void main(String[] args) {
        /*int[] input = {-1,0,3,5,9,12};
        System.out.println(sort(input,0));
        System.out.println(Integer.MAX_VALUE);
        System.out.println(2^31-1);*/
        List<Integer[]> collect = Stream.iterate(new Integer[]{0, 1}, a -> new Integer[]{a[1], a[0] + a[1]}).limit(40).collect(Collectors.toList());

        Integer[] size = collect.get(collect.size() - 1);
        System.out.println(size[0]);
        System.out.println(size[1]);

        System.out.println(collect.get(collect.size() - 1)[1]);


    }
}
