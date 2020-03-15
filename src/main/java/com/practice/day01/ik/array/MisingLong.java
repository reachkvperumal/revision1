package com.practice.day01.ik.array;

import java.util.Arrays;
import java.util.List;

public class MisingLong {

    //optimal solution
    static long findMissing(List<Long> arr) {
        int size = (int) (Math.pow(2, 32) / 8);
        byte[] b = new byte[size];

        for (long i : arr) {
            //set the corresponding bit true
            int pos = (int) i / 8;
            b[pos] |= 1 << i % 8;
        }

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < 8; j++) {
                //identify the unset bit and return
                if ((b[i] & 1 << j) == 0)
                    return i * 8l + j;
            }
        }
        return 0L;
    }

    static void swap(List<Long> arr, int i, int j) {
        Long l = arr.get(i);
        arr.set(i, arr.get(j));
        arr.set(j, l);
    }

    static long findLong(List<Long> arr) {
        int size = arr.size();
        int i = 0;

        while (i < size) {
            int j = arr.get(i).intValue();
            if (arr.get(i) >= 0L && arr.get(i) < size && arr.get(j) >= 0L && arr.get(j) < size && arr.get(i) != arr.get(j))
                swap(arr, i, j);
            else
                i++;
        }

        for (i = 0; i < size; i++) {
            if (arr.get(i) != i)
                return i + 1L;
        }
        return i + 1L;
    }

    public static void main(String[] args) {
        List<Long> list = Arrays.asList(0l, 1l, 2l, 3l);
        System.out.println(findLong(list));
        System.out.println(findMissing(list));
    }
}
