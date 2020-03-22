package com.practice.day01.cache;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    private static class Entry {
        private int key;
        private int val;
        private Entry left;
        private Entry right;

        public Entry(int k, int v) {
            this.key = k;
            this.val = v;
        }
    }

    private final int LRU_CACHE_SIZE;

    private final Map<Integer, Entry> map;

    private Entry start, end;

    public LRUCache(int LRU_CACHE_SIZE, Map<Integer, Entry> map) {
        this.LRU_CACHE_SIZE = LRU_CACHE_SIZE;
        this.map = map;
    }

    public void putEntry(int key, int value) {
        if (this.map.containsKey(key)) {
            Entry entry = this.map.get(key);
            entry.val = value;
            remove(entry);
            add(entry);
        } else {
            Entry entry = new Entry(key, value);
            if (this.map.size() > this.LRU_CACHE_SIZE) {
                this.map.remove(end.key);
                remove(end);
            }
            add(entry);
            this.map.put(key, entry);
        }
    }

    public int getEntry(int key) {
        if (this.map.containsKey(key)) {
            Entry entry = this.map.get(key);
            remove(entry);
            add(entry);
            return entry.val;
        }
        return -1;
    }

    private void add(Entry node) {
        node.left = null;
        node.right = start;

        if (start != null)
            start.left = node;
        start = node;
        if (end == null)
            end = start;
    }

    private void remove(Entry node) {
        if (node.left != null)
            node.left.right = node.right;
        else
            start = node.right;

        if (node.right != null)
            node.right.left = node.left;
        else
            end = node.left;
    }

    public static void main(String[] args) {
        LRUCache lrucache = new LRUCache(4, new HashMap<>());
        lrucache.putEntry(1, 1);
        lrucache.putEntry(10, 15);
        lrucache.putEntry(15, 10);
        lrucache.putEntry(10, 16);
        lrucache.putEntry(12, 15);
        lrucache.putEntry(18, 10);
        lrucache.putEntry(13, 16);

        System.out.println(lrucache.getEntry(1));
        System.out.println(lrucache.getEntry(10));
        System.out.println(lrucache.getEntry(15));
    }
}
