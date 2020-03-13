package com.practice.day01;

import org.junit.jupiter.api.Test;

import java.util.PriorityQueue;
import java.util.Queue;

public class PrintTest {

    @Test
    public void printTest() {
        String s = "KV";
        int space = 10;
        for (int i = 1; i <= space; i++) {
            //     System.out.printf("%"+i+"s%s%n"," ","KV");
        }

        Queue<Character> q = new PriorityQueue<>();
        q.offer('-');
        q.offer('+');
        q.offer('*');
        q.offer('/');
        q.offer('^');
        System.out.println(q);


    }
}
