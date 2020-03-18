package com.practice.day01;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class HammingWeightTest {

    @Test
    public void testHamming() {
        int n = Integer.MAX_VALUE;
        System.out.println(n);

        int count = 0;
        while (n != 0) {
            count += n & 1;
            n = n >>> 1;
        }
        System.out.println(count);
    }

    @Test
    public void swapTest() {
        int[] nums = {0, 1, 2, 3, 4, 5, 6};

        int interval = 1;
        for (int i = 0; i + 1 < nums.length; i += 2) {
            System.out.println(i + 1);
            swap(nums, i, i + 1);
        }
        //1, 0, 3, 2, 4, 5, 6
        System.out.println(Arrays.toString(nums));

    }

    static void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
