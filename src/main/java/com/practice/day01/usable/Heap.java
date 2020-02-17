package com.practice.day01.usable;

import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;

public class Heap<T extends Comparable<T>> {
    private T[] heap;
    private int size;

    public Heap(int size) {
        this.size = 0;
        heap = (T[]) new Comparable[size + 1];
    }

    public Heap(T[] array) {
        size = array.length;
        heap = (T[]) new Comparable[size + 1];
        System.arraycopy(array, 0, heap, 1, size);
        buildHeap();
    }

    private int parent(int pos) {
        return pos / 2;
    }

    private int leftChild(int pos) {
        return (pos * 2);
    }

    private int rightChild(int pos) {
        return (pos * 2) + 1;
    }

    private boolean isLeaf(int pos) {
        return pos > (pos / 2) && pos <= size;
    }

    private void swap(int i, int j) {
        T tmp = heap[i];
        heap[i] = heap[j];
        heap[j] = tmp;
    }

    //if the node is non leaf and greater than any of it's child
    private void minHeapify(int pos) {
        T t = heap[pos];
        if (!isLeaf(pos)) {
            int leftPos = leftChild(pos);
            int rightPos = rightChild(pos);
            T leftChild = heap[leftPos];
            T rightChild = heap[rightPos];
            if (t.compareTo(leftChild) > 0 || t.compareTo(rightChild) > 0) {
                if (leftChild.compareTo(rightChild) > 0) {
                    swap(pos, leftPos);
                    minHeapify(leftPos);
                } else {
                    swap(pos, rightPos);
                    minHeapify(rightPos);
                }
            }
        }
    }

    private void doubleUp() {
        T[] tmp = heap;
        heap = (T[]) new Comparable[size * 2];
        System.arraycopy(tmp, 1, heap, 1, size);
    }

    public void insert(T t) {
        if (size == heap.length - 1) doubleUp();
        heap[++size] = t;
        int current = size;
        while (current > 1 && heap[current].compareTo(heap[parent(current)]) < 0) {
            swap(current, parent(current));
            current = parent(current);
        }
    }

    public void buildHeap() {
        for (int k = size / 2; k > 0; k--)
            minHeapify(k);
    }

    @Override
    public String toString() {
        return "[" + Arrays.stream(heap).filter(Objects::nonNull).map(String::valueOf).collect(Collectors.joining(", ")) + "]";
    }

    public T delete() {
        T t = heap[1];
        heap[1] = heap[size--];
        minHeapify(1);
        return t;
    }

    public static void main(String[] args) {
        Heap<Integer> heap = new Heap(15);
        heap.insert(5);
        heap.insert(3);
        heap.insert(17);
        heap.insert(10);
        heap.insert(84);
        heap.insert(19);
        heap.insert(6);
        heap.insert(22);
        heap.insert(9);
        heap.buildHeap();
        System.out.println(heap);
    }

}
