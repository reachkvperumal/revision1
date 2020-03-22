package com.practice.day01;

import org.junit.jupiter.api.Test;

public class MissingIntTest {

    @Test
    public void missingNumTest() {

        int[] nums = {0, 1, 2, 3, 4, 6, 7, 8};
        int missing = nums.length;
        for (int i = 0; i < nums.length; i++)
            missing ^= i ^ nums[i];
        System.out.println(missing);
    }
}
