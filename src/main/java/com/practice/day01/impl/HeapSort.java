package com.practice.day01.impl;

import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;

public class HeapSort<T extends Comparable<T>> {

    private int size;
    private int maxSize;
    private T[] heap;

    public HeapSort(int maxSize) {
        this.maxSize = maxSize;
        this.size = 0;
        this.heap = (T[]) new Comparable[this.maxSize];
    }

    public HeapSort(T[] array) {
        this.size = array.length;
        this.maxSize = this.size;
        this.heap = (T[]) new Comparable[this.size];
        System.arraycopy(array, 0, heap, 0, this.size);
        this.sort();
    }

    private void swap(int i, int j) {
        T tmp = this.heap[i];
        this.heap[i] = this.heap[j];
        this.heap[j] = tmp;
    }

    private void heapify(int n, int k) {
        int largest = k;
        int leftPos = 2 * k + 1;
        int rightPos = 2 * k + 2;

        if (leftPos < n && heap[leftPos].compareTo(heap[largest]) > 0)
            largest = leftPos;

        if (rightPos < n && heap[rightPos].compareTo(heap[largest]) > 0)
            largest = rightPos;

        if (largest != k) {
            swap(k, largest);
            heapify(n, largest);
        }
    }

    private void sort() {
        int n = this.size;
        for (int i = size / 2 - 1; i >= 0; i--) {
            heapify(n, i);
        }

        for (int i = n - 1; i >= 0; i--) {
            swap(i, 0);
            heapify(i, 0);
        }
    }

    private void doubleUp() {
        T[] tmp = this.heap;
        this.heap = (T[]) new Comparable[this.maxSize * 2];
        System.arraycopy(tmp, 0, this.heap, 0, this.size);
    }

    public void insert(T t) {
        if (this.size == this.maxSize)
            this.doubleUp();
        this.heap[this.size++] = t;
        this.sort();
    }

    public T delete() {
        T t = this.heap[0];
        this.heap[0] = this.heap[this.size - 1];
        this.heap[this.size - 1] = null;
        --this.size;
        this.sort();
        return t;
    }

    @Override
    public String toString() {
        return String.format("[%s]",
                Arrays.stream(this.heap).filter(Objects::nonNull)
                        .map(String::valueOf).collect(Collectors.joining(",")));
    }

    public static void main(String[] args) {
        Integer[] arr = {7, 8, 6, 1};
        HeapSort<Integer> heap = new HeapSort<>(arr);
        System.out.println(heap);

        String[] str = {"E", "B", "M", "U", "J", "A", "R", "C", "N", "S", "L"};
        HeapSort<String> strHeap = new HeapSort<>(str.length);
        for (String s : str)
            strHeap.insert(s);

        System.out.println(strHeap);

        System.out.println(heap.delete());
        System.out.println(heap);

        System.out.println(strHeap.delete());
        System.out.println(strHeap);
    }
}
