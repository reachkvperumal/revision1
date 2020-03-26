package com.practice.day01;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

    @Test
    public void priorityQueueTest() {
        int[] items = {1, 2, 3, 4};
        Queue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        int count = 0;
        while (count < items.length)
            queue.offer(items[count++]);

        System.out.println(queue);
        assertEquals(7, queue.stream().limit(2).mapToInt(o -> o).sum());

    }
}
