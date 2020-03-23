package com.practice.day01.bloomberg.number;

public class MaxAreaOfIsland {
    static int dfs(int[][] grid, int r, int c) {

        int nr = grid.length;
        int nc = grid[0].length;

        if (r < 0 || c < 0 || r >= nr || c >= nc || grid[r][c] == 0)
            return 0;

        grid[r][c] = 0;

        return 1 + dfs(grid, r + 1, c) + dfs(grid, r - 1, c) + dfs(grid, r, c + 1) + dfs(grid, r, c + 1);
    }

    static int maxArea(int[][] grid) {
        int nr = grid.length;
        int nc = grid[0].length;
        if (grid[0] == null || nc == 0)
            return 0;
        int count = 0;
        for (int i = 0; i < nr; i++) {
            for (int j = 0; j < nc; j++) {
                count = Math.max(count, dfs(grid, i, j));
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] grid = {{0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}};
        System.out.println(maxArea(grid));

        int[][] grid1 = {{0, 0, 0, 0, 0, 0, 0, 0}};
        System.out.println(maxArea(grid1));
    }
}
