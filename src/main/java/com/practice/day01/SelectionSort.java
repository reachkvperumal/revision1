package com.practice.day01;

public class SelectionSort {

    static void sort(int[] input) {

        for (int i = 0; i < input.length; i++) {
            int current = i;

            for (int j = i + 1; j < input.length; j++) {
                if (input[current] > input[j]) {
                    current = j;
                }
            }

            if (current != i) {
                int tmp = input[i];
                input[i] = input[current];
                input[current] = tmp;
            }

        }
    }

    public static void main(String[] args) {
        int[] input = {5, 4, 1, 6, 2};
        sort(input);
        for (int j : input) {
            System.out.println(j);
        }
    }
}
