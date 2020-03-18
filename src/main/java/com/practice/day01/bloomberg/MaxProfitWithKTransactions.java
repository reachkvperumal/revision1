package com.practice.day01.bloomberg;

public class MaxProfitWithKTransactions {

    static int profitWithKTransactions(int[] prices, int k) {
        int n = prices.length;
        if (n == 0)
            return 0;

        int[][] profits = new int[k + 1][n];

        for (int i = 1; i < k + 1; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = 1; j < n; j++) {
                max = Math.max(max, profits[i - 1][j - 1] - prices[j - 1]);
                profits[i][j] = Math.max(profits[i][j - 1], max + prices[j]);
            }
        }
        return profits[k][n - 1];
    }

    public static void main(String[] args) {
        int[] prices = {5, 11, 3, 50, 60, 90};
        System.out.println(profitWithKTransactions(prices, 2));
    }
}
