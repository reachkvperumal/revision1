package com.practice.day01;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SolutionTest {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int rootSize = scan.nextInt();
        List<List<Integer>> root = new ArrayList<>(rootSize);

        for (int i = 0; i < rootSize; i++) {
            int childSize = scan.nextInt();
            List<Integer> child = new ArrayList<>(childSize);
            for (int j = 0; j < childSize; j++) {
                child.add(scan.nextInt());
            }
            root.add(child);
        }

        ((ArrayList) root).trimToSize();
        int q = scan.nextInt();

        for (int i = 0; i < q; q++) {
            int rootIdx = scan.nextInt();
            int childIdx = scan.nextInt();
            if (rootIdx > 0 && rootIdx <= rootSize) {
                List<Integer> ans = root.get(rootIdx - 1);
                if (childIdx > 0 && childIdx <= ans.size()) {
                    System.out.println(ans.get(childIdx - 1));
                } else {
                    System.out.println("ERROR!");
                }
            } else {
                System.out.println("ERROR!");
            }

        }
        scan.close();

        int[][] arr = new int[6][6];
        int row = arr.length - 2;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length - 2; i++) {
            for (int j = 0; j < arr[i].length - 2; j++) {
                int sum = ((arr[i][j] + arr[i][j + 1] + arr[i][j + 2]) +
                        (arr[i + 1][j + 1] +
                                arr[i + 2][j] +
                                arr[i + 2][j + 2] +
                                arr[i + 2][j + 2]));
                max = Math.max(max, sum);
            }
        }

    }
}
