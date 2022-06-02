package com.algo.recursion.day01;

import java.util.*;

import static java.lang.Math.max;

public class SlidingWindow {

    static int[] arr = {1, 2, 3, 1, 4, 5, 2, 3, 6};  //{1, 9, -1, -2, 7, 3, -1, 2};


    //o(n*k)
    private static void bruteForce(int k) {
        int maxWindow = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length - k; i++) {
            int currentWindow = 0;
            for (int j = i; j < i + k; j++) {
                currentWindow += arr[j];
            }
            maxWindow = max(currentWindow, maxWindow);
        }
        System.out.println(maxWindow);
    }

    //o(n)
    private static void algo2(int k) {
        int winSum = Arrays.stream(arr).limit(k).sum();
        System.out.println(winSum);
        int maxSum = Integer.MIN_VALUE;
        for (int i = k; i < arr.length; i++) {
            winSum += arr[i] - arr[i - k];
            maxSum = max(winSum, maxSum);
        }
        System.out.println(maxSum);
    }


    public static void main(String[] args) {

        algo2(3);



    }
}
