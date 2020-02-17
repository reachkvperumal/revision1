package com.practice.day01;


import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SortTest {

    @Test
    public void fibTest() {

        Stream.iterate(new Long[]{0l, 1l}, a -> new Long[]{a[1], a[0] + a[1]}).limit(20).forEach(a -> System.out.println(a[0]));

        assertEquals(0, 0 / 2);
    }
}
