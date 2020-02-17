package com.practice.day01;

public class MinHeap {

    private int[] heap;

    private int size;

    private int maxSize;

    public MinHeap(int maxSize) {
        this.maxSize = maxSize;
        this.size = 0;
        heap = new int[maxSize + 1];
        heap[0] = 0x80000000;
    }

    // pos - 1 / 2
    private int parent(int pos) {
        return pos / 2;
    }

    private int leftChild(int pos) {
        return (2 * pos);
    }

    private int rightChild(int pos) {
        return (2 * pos) + 1;
    }

    private boolean isLeaf(int pos) {
        return pos > (size / 2) && pos <= size;
    }

    private void swap(int i, int j) {
        int tmp = this.heap[i];
        this.heap[i] = this.heap[j];
        this.heap[j] = tmp;
    }

    public static void main(String[] args) {
        MinHeap heap = new MinHeap(3);
        System.out.println(heap.isLeaf(2));
    }


}
