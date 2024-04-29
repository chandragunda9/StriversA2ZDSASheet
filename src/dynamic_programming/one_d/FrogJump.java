package dynamic_programming.one_d;

import java.util.Arrays;

public class FrogJump {
    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 10};
        System.out.println(frogJump(arr.length, arr));
    }

    public static int frogJump(int n, int[] heights) {
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return f(n - 1, heights, dp);
    }

    static int f(int ind, int[] heights, int[] dp) {
        if (ind == 0)
            return 0;
        if (ind == 1)
            return Math.abs(heights[1] - heights[0]);
        if (dp[ind] != -1)
            return dp[ind];
        int oneStepEn = Math.abs(heights[ind] - heights[ind - 1]) + f(ind - 1, heights, dp);
        int twoStepEn = Math.abs(heights[ind] - heights[ind - 2]) + f(ind - 2, heights, dp);
        return dp[ind] = Math.min(oneStepEn, twoStepEn);
    }
}
