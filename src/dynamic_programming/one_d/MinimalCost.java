package dynamic_programming.one_d;

import java.util.Arrays;

public class MinimalCost {
    public static void main(String[] args) {
        int n = 3, k = 1;
        int[] arr = {2, 5, 2};
        System.out.print(minimizeCost(n, k, arr));
    }

    public static int minimizeCost(int n, int k, int[] height) {
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return (f(n - 1, k, height, dp));
    }

    static int f(int ind, int k, int[] height, int[] dp) {
        if (ind == 0)
            return 0;
        if (dp[ind] != -1)
            return dp[ind];
        int energy = Integer.MAX_VALUE;
        for (int i = 1; i <= k && ind >= i; i++) {
            energy = Math.min(energy, Math.abs(height[ind] - height[ind - i]) + f(ind - i, k, height, dp));
        }
        return dp[ind] = energy;
    }
}
