package com.practice.day01.ik;

import java.util.Arrays;

public class GroupTheNumbers {

    static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
/*
 if(arr==null || arr.length== 0)
         return null;
        int i =0;
        for(int j = 0; j<arr.length; j++){
            if(arr[j] % 2 == 0){
                swap(arr,i,j);
                i++;
            }

        }
        return arr;
 */


    /*
     * Complete the function below.
     */
    static int[] solve(int[] arr) {

        if (arr == null || arr.length == 0)
            return null;
        int i = 0;
        for (int j = 0; j < arr.length; j++) {
            if (arr[j] % 2 == 0) {
                swap(arr, i, j);
                i++;
            }
        }

        return arr;
    }

    public static void main(String[] args) {
        int[] a = {8, 4, 9, 5, 2, 9, 5, 7, 10};
        System.out.println(Arrays.toString(solve(a)));
    }
}
