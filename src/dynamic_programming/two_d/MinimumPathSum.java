package dynamic_programming.two_d;

import java.util.Arrays;

public class MinimumPathSum {
    public static void main(String[] args) {
        int[][] grid = {{5, 9, 6}, {11, 5, 2}};
//        int[][] grid = {{5, 9, 6}};
        System.out.println(minSumPath(grid));
    }

    public static int minSumPath(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        return f(m - 1, n - 1, grid, dp);
    }

    static int f(int i, int j, int[][] grid, int[][] dp) {
        if (i == 0 && j == 0)
            return grid[0][0];
        if (i < 0 || j < 0)
            return (int) (1e9 + 7);
        if (dp[i][j] != -1)
            return dp[i][j];
        int left = grid[i][j] + f(i, j - 1, grid, dp);
        int up = grid[i][j] + f(i - 1, j, grid, dp);
        return dp[i][j] = Math.min(left, up);
    }
}
