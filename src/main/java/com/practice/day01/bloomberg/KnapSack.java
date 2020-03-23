package com.practice.day01.bloomberg;

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
        //int val[] = new int[]{60, 100, 120};
        //int wt[] = new int[]{10, 20, 30};

        // n = size of input 
        // W = target weight  
        // Absolute space/ time 
        // Space : 
        //      Input = 2n + 1 
        //      Additional = n * W 
        // Time = n * W   
        // Big O notation Space / time 
        // Space 
        //      Input = O(N) 
        //      Additional = O(N^2) 
        //      Overall = O(N^2)  
        // Time = O(N^2)          
        // Complexity : O(K), O(LOG(N)), O(N), O(NLOG(N)), O(N^2), O(N^3)

        int wt[] = {1, 56, 42, 78, 12};
        int val[] = {50, 30, 20, 10, 50};
        int W = 150;
        System.out.println(compute(wt, val, W, wt.length));
    }
}
