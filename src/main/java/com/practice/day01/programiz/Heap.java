package com.practice.day01.programiz;

import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;

public class Heap<T extends Comparable<T>> {

    private T[] heap;
    private int maxSize;
    private int size;

    public Heap(int maxSize) {
        this.maxSize = maxSize;
        heap = (T[]) new Comparable[this.maxSize];
        this.size = 0;
    }

    public Heap(T[] array) {
        this.maxSize = array.length;
        this.size = this.maxSize - 1;
        heap = (T[]) new Comparable[array.length];
        System.arraycopy(array, 0, heap, 0, array.length);
        this.sort();
    }

    private void sort() {
        this.sort(this.heap);
    }

    private void swap(int i, int j) {
        T t = heap[i];
        heap[i] = heap[j];
        heap[j] = t;
    }


    private void heapify(int n, int i) {
        int largest = i;
        int leftPos = 2 * i + 1;
        int rightPos = 2 * i + 2;

        if (leftPos < n && heap[leftPos].compareTo(heap[largest]) > 0)
            largest = leftPos;

        if (rightPos < n && heap[rightPos].compareTo(heap[largest]) > 0)
            largest = rightPos;

        if (largest != i) {
            swap(largest, i);
            heapify(n, largest);
        }
    }

    public void sort(T[] array) {
        heap = (T[]) new Comparable[array.length];
        System.arraycopy(array, 0, heap, 0, array.length);
        int n = heap.length;

        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(n, i);

        for (int i = n - 1; i >= 0; i--) {
            swap(i, 0);
            heapify(i, 0);
        }

    }

    private void doubleUp() {
        T[] tmp = this.heap;
        this.maxSize = this.maxSize * 2;
        this.heap = (T[]) new Comparable[this.maxSize];
        System.arraycopy(tmp, 0, heap, 0, this.size);
    }

    public void add(T t) {
        if (this.size == this.maxSize)
            doubleUp();

        if (this.size == 0)
            heap[this.size++] = t;
        else {
            heap[this.size++] = t;
            for (int i = this.size / 2 - 1; i >= 0; i--) {
                heapify(this.size, i);
            }
            for (int i = this.size - 1; i >= 0; i--) {
                this.swap(i, 0);
                heapify(i, 0);
            }
        }

    }

    public T remove() {
        T removed = this.heap[0];
        this.heap[0] = this.heap[this.size - 1];
        this.heap[this.size - 1] = null;
        this.size--;
        for (int j = this.size / 2 - 1; j >= 0; j--)
            heapify(this.size, j);

        for (int j = this.size - 1; j >= 0; j--) {
            swap(j, 0);
            heapify(j, 0);
        }

        return removed;
    }

    @Override
    public String toString() {
        return String.format("[%s]", Arrays.stream(this.heap).filter(Objects::nonNull).map(String::valueOf).collect(Collectors.joining(",")));
    }

    public static void main(String[] args) {
        Integer arr[] = {1, 12, 9, 5, 6, 10};
        // Heap<Integer> heap = new Heap<>(arr);
        // heap.print();
        Heap<Integer> heap = new Heap<>(2);
        for (Integer i : arr)
            heap.add(i);

        System.out.println(heap);

        heap.remove();

        System.out.println(heap);
    }


}
