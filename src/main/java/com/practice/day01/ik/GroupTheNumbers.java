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


    static void wiggleSort(int[] arr) {
        int i = 0, j = arr.length - 1;

        while (i < j) {
            if (arr[i] % 2 != 0) {
                swap(arr, i, j);
                j--;
            } else
                i++;
        }
    }

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

        int[] a1 = {8, 4, 9, 5, 2, 9, 5, 7, 10};
        wiggleSort(a1);
        System.out.println(Arrays.toString(a1));
    }
}
