package dynamic_programming.two_d;

import java.util.Arrays;

public class UniquePaths {
    public static void main(String[] args) {
        int m = 3, n = 2;
        System.out.print(uniquePaths(m, n));
    }

    public static int uniquePaths(int m, int n) {
        //method 1
//        int[][] dp = new int[m][n];
//        for (int i = 0; i < dp.length; i++) {
//            Arrays.fill(dp[i], -1);
//        }
//        int ans = f(m - 1, n - 1, dp);
//        System.out.println(Arrays.deepToString(dp));
//        return ans;

        //method 2
//        return tab(m, n);

        //method 3
        return count(m, n);
    }

    static int count(int m, int n) {
        int N = m + n - 2, R = Math.min(m - 1, n - 1);
        double ans = 1;
        //finding C(N, R) combination
        for (int i = 1; i <= R; i++) {
            ans = ans * (N - R + i) / i;
        }
        return (int) ans;
    }

    static int f(int row, int col, int[][] dp) {
        if (row == 0 && col == 0)
            return 1;
        if (row < 0 || col < 0)
            return 0;
        if (dp[row][col] != -1)
            return dp[row][col];
        int left = f(row, col - 1, dp);
        int up = f(row - 1, col, dp);
        return dp[row][col] = left + up;
    }

    static int tab(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0)
                    dp[i][j] = 1;
                else {
                    int left = 0, up = 0;
                    if (j > 0)
                        left += dp[i][j - 1];
                    if (i > 0)
                        up += dp[i - 1][j];
                    dp[i][j] = left + up;
                }
            }
        }
        return dp[m - 1][n - 1];
    }
}
