package com.practice.day01.ik;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class KNN {

    private static class Point implements Comparable<Point> {

        private List<Integer> coords;
        private double distance;

        public Point(List<Integer> coords, int p_x, int p_y) {
            this.coords = coords;
            int x = coords.get(0), y = coords.get(1);
            this.distance = Math.sqrt((p_x - x) * 1l * (p_x - x) + (p_y - y) * 1l * (p_y - y));
        }

        @Override
        public int compareTo(Point o) {
            return Double.compare(this.distance, o.distance);
        }
    }

    public static List<List<Integer>> nearest_neighbours(int p_x, int p_y, int k, List<List<Integer>> n_points) {
        Point[] points = n_points.stream().map(o -> new Point(o, p_x, p_y)).toArray(Point[]::new);
        shuffle(points);
        topK(points, k);

        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < k; i++)
            result.add(points[i].coords);


        return result;
    }

    private static void shuffle(Point[] points) {
        int k = points.length;
        for (int i = 0; i < points.length; i++)
            swap(points, new Random().nextInt((k - i) + i), i);

    }

    private static void topK(Point[] points, int k) {
        int left = 0, right = points.length - 1;
        while (left < right) {
            int p = split(points, left, right);
            if (p == k)
                return;
            else if (p < k)
                left = p + 1;
            else
                right = p - 1;
        }
    }

    private static int split(Point[] points, int left, int right) {
        Point pivot = points[left];
        int i = left, j = right + 1;
        while (true) {
            while (i < right && points[++i].compareTo(pivot) < 0) ;
            while (j > left && points[--j].compareTo(pivot) > 0) ;
            if (i >= j)
                break;

            swap(points, i, j);
        }
        swap(points, j, left);
        return j;
    }


    private static void swap(Point[] points, int i, int j) {
        Point tmp = points[i];
        points[i] = points[j];
        points[j] = tmp;
    }

    public static void main(String[] args) {
        List<List<Integer>> input = new ArrayList<>();
        input.add(Arrays.asList(-8, -3));
        input.add(Arrays.asList(-1, -6));
        input.add(Arrays.asList(-8, -7));
        input.add(Arrays.asList(-7, -9));
        input.add(Arrays.asList(-1, -9));
        List<List<Integer>> result = nearest_neighbours(4, 5, 2, input);
        System.out.println(result);
    }


}
