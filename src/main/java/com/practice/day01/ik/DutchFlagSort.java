package com.practice.day01.ik;

import java.util.Arrays;

public class DutchFlagSort {

    static void swap(char[] balls, int i, int j) {
        char tmp = balls[i];
        balls[i] = balls[j];
        balls[j] = tmp;
    }

    static void sort(char[] balls) {

        int size = balls.length;
        int start = 0, mid = 0;
        int end = size - 1;
        //char tmp = '\0';


        while (mid <= end) {
            switch (balls[mid]) {
                case 'R': {
                    swap(balls, start, mid);
                    start++;
                    mid++;
                    break;
                }
                case 'G': {
                    mid++;
                    break;
                }
                case 'B': {
                    swap(balls, mid, end);
                    end--;
                    break;
                }
            }
        }


    }

    public static void main(String[] args) {
        char[] balls = {'G', 'B', 'G', 'G', 'R', 'B', 'R', 'G'};
        sort(balls);
        System.out.println(Arrays.toString(balls));
    }

}
