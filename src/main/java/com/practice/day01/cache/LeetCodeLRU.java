package com.practice.day01.cache;

import java.util.HashMap;
import java.util.Map;

public class LeetCodeLRU {
    class Entry {
        int key;
        int value;
        Entry prev;
        Entry next;
    }

    private void addNode(Entry node) {
        /**
         * Always add the new node right after head.
         */
        node.prev = head;
        node.next = head.next;

        head.next.prev = node;
        head.next = node;
    }

    private void removeNode(Entry node) {
        /**
         * Remove an existing node from the linked list.
         */
        Entry prev = node.prev;
        Entry next = node.next;

        prev.next = next;
        next.prev = prev;
    }

    private void moveToHead(Entry node) {
        /**
         * Move certain node in between to the head.
         */
        removeNode(node);
        addNode(node);
    }

    private Entry popTail() {
        /**
         * Pop the current tail.
         */
        Entry res = tail.prev;
        removeNode(res);
        return res;
    }

    private Map<Integer, Entry> cache = new HashMap<>();
    private int size;
    private int capacity;
    private Entry head, tail;

    public LeetCodeLRU(int capacity) {
        this.size = 0;
        this.capacity = capacity;

        head = new Entry();
        // head.prev = null;

        tail = new Entry();
        // tail.next = null;

        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        Entry node = cache.get(key);
        if (node == null) return -1;

        // move the accessed node to the head;
        moveToHead(node);

        return node.value;
    }

    public void put(int key, int value) {
        Entry node = cache.get(key);

        if (node == null) {
            Entry newNode = new Entry();
            newNode.key = key;
            newNode.value = value;

            cache.put(key, newNode);
            addNode(newNode);

            ++size;

            if (size > capacity) {
                // pop the tail
                Entry tail = popTail();
                cache.remove(tail.key);
                --size;
            }
        } else {
            // update the value.
            node.value = value;
            moveToHead(node);
        }
    }
}
