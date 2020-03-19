package com.practice.day01.bloomberg;

public class MedianOf2SortedArrayOfDifferentLength {

    static double findMedian(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length)
            findMedian(nums2, nums1);

        int x = nums1.length;
        int y = nums2.length;

        int start = 0;
        int end = x;

        while (start <= end) {
            int partitionX = (start + end) / 2;
            int partitionY = ((x + y + 1) / 2) - partitionX;

            int maxLeftX = (partitionX == 0) ? Integer.MIN_VALUE : nums1[partitionX - 1];
            int minRightX = (partitionX == x) ? Integer.MAX_VALUE : nums1[partitionX];

            int maxleftY = (partitionY == 0) ? Integer.MIN_VALUE : nums2[partitionY - 1];
            int minRightY = (partitionY == y) ? Integer.MAX_VALUE : nums2[partitionY];

            if (maxLeftX <= minRightY && maxleftY <= minRightX) {
                if ((x + y) % 2 == 0)
                    return (Math.max(maxLeftX, maxleftY) + Math.min(minRightX, minRightY)) / 2d;
                else
                    return Math.max(maxLeftX, maxleftY);
            } else if (maxLeftX > minRightY)
                end = partitionX - 1;
            else
                start = partitionX + 1;

        }
        return Double.NEGATIVE_INFINITY;
    }

    public static void main(String[] args) {
        int[] x = {1, 2};
        int[] y = {3, 4};
        System.out.println(findMedian(x, y));
    }
}
