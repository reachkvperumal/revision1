package com.practice.day01.ik;

import java.util.Arrays;

public class ProductArray {

    static int[] product(int[] nums) {
        int size = nums.length;
        int[] product = new int[size];
        int[] left = new int[size];
        int[] right = new int[size];
        left[0] = 1;
        right[size - 1] = 1;

       /* for (int i = 0; i < size - 1; i++)
            left[i + 1] = left[i] * nums[i];
*/
        for (int i = 1; i < size; i++)
            left[i] = left[i - 1] * nums[i - 1];

        for (int i = size - 1; i > 0; i--)
            right[i - 1] = right[i] * nums[i];

        for (int i = 0; i < size; i++)
            product[i] = left[i] * right[i];
        return product;
    }

    static int[] productSelf(int[] nums) {
        int size = nums.length;
        int[] result = new int[size];

        result[size - 1] = 1;
        for (int i = size - 1; i > 0; i--)
            result[i - 1] = result[i] * nums[i];

        int left = 1;
        for (int i = 0; i < size; i++) {
            result[i] = result[i] * left;
            left *= nums[i];
        }
        return result;
    }

    //leet code problem solution
    static int[] getProductArray(int[] nums) {
        int size = nums.length;
        int[] result = new int[size];
        // int mod = (int) Math.pow(10, 9) + 7;

        int left = 1;
        for (int i = 0; i < size; i++) {
            result[i] = left;
            //    nums[i] = nums[i] > 0 ? nums[i] : (mod + nums[i]) % mod;
//            left = (int) ((left * 1l * nums[i];//) % mod);
            left = left * nums[i];
        }

        int right = 1;
        for (int i = size - 1; i >= 0; i--) {
            //  result[i] = (int) ((result[i] * 1l * right) % mod);
            result[i] = right * result[i];
//            right = (int) ((right * 1l * nums[i]) % mod);
            right = right * nums[i];
        }

        return result;
    }


    public static void main(String[] args) {
        int[] arr = {1, 2, 3, -0x7fff, 5};
        System.out.println(Arrays.toString(product(arr)));
        System.out.println(Arrays.toString(productSelf(arr)));

        int[] arr1 = {-1000000000, -1000000000};

        System.out.println(Arrays.toString(getProductArray(arr1)));
      /*  System.out.println((int) (Math.pow(10, 9) + 7));
        System.out.println(-0x7fff);*/
        int[] arr2 = {1, 2, 3, 4};
        System.out.println(Arrays.toString(getProductArray(arr2)));
    }

}
