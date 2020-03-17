package com.practice.day01;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

public class CollectionsTutorialTest {

    @Test
    public void queueTest() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        System.out.println(queue);

        int z = 2, y = 4, x = 3, carry = 0;

        int sum = carry + x + y;
        carry = sum / 10;
        int t = sum % 10;


    }
}
