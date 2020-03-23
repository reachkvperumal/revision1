package com.practice.day01.bloomberg.dp;

public class KnapSack {

    static int compute(int[] weight, int[] val, int W, int n) {
        int[][] aux = new int[n + 1][W + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= W; j++) {
                if (i == 0 || j == 0)
                    aux[i][j] = 0;
                else if (j < weight[i - 1])
                    aux[i][j] = aux[i - 1][j];
                else
                    aux[i][j] = Math.max(val[i - 1] + aux[i - 1][j - weight[i - 1]], aux[i - 1][j]);
            }
        }
        return aux[n][W];
    }

    public static void main(String[] args) {
        int val[] = new int[]{60, 100, 120};
        int wt[] = new int[]{10, 20, 30};
        int W = 50;
        System.out.println(compute(wt, val, W, wt.length));
    }
}
