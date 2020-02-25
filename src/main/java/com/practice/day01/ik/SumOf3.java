package com.practice.day01.ik;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SumOf3 {

    static String[] findZeroSum(int[] arr) {
        int k = arr.length;
        List<String> results = new ArrayList<>();
        Arrays.sort(arr);
        for (int i = 0; i < k - 2; i++) {
            if (i > 0 && arr[i] == arr[i - 1])
                continue;
            int left = i + 1;
            int right = k - 1;
            while (left < right) {
                int sum = arr[i] + arr[left] + arr[right];
                if (sum == 0) {
                    results.add(String.format("%d,%d,%d", arr[i], arr[left], arr[right]));
                    left++;
                    right--;
                    while (left < right && arr[left] == arr[left - 1])
                        left++;
                    while (left < right && arr[right] == arr[right + 1])
                        right++;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return results.stream().toArray(String[]::new);
    }

    public static void main(String[] args) {
        int[] i = {10, 3, -4, 1, -6, 9};
        int[] j = {-7, -5, -3, -99, -245};
        System.out.println(Arrays.toString(findZeroSum(i)));
        System.out.println(Arrays.toString(findZeroSum(j)));

    }
}
