package com.practice.day01;

import org.junit.jupiter.api.Test;

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

}
