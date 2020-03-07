package com.practice.day01.ik;

import java.util.Arrays;
import java.util.List;

public class MissingLong {

    static long find(List<Long> arr) {
        int size = (int) Math.pow(2, 32) / 8;
        byte[] b = new byte[size];

        for (long i : arr) {
            int pos = (int) i / 8;
            //set the corresponding bit true
            b[pos] |= 1 << i % 8;
        }

        for (int i = 0; i < arr.size(); i++) {
            for (int j = 0; j < 8; j++) {
                //find the unset bit and return
                if ((b[i] & 1 << j) == 0)
                    return i * 8l + j;
            }
        }
        return 0l;
    }

    public static void main(String[] args) {
        System.out.println(find(Arrays.asList(0l, 1l, 2l, 3l, 4l, 5l, 8l)));
    }

}
