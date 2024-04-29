package dynamic_programming.one_d;

import java.util.Arrays;

public class ClimbingStairs {
    static int mod = (int) (1e9 + 7);

    public static void main(String[] args) {
        int nStairs = 3;
        System.out.println(countDistinctWayToClimbStair(nStairs));
    }

    public static long countDistinctWayToClimbStair(int nStairs) {
//        long[] dp = new long[nStairs + 1];
//        Arrays.fill(dp, -1);
//        return f(nStairs, dp);
//        return fTabulation(nStairs);
        return f(nStairs);
    }

    static long f(int n) {
        long prev = 1, prev2 = 1, curr = 0;
        for (int i = 2; i <= n; i++) {
            curr = (prev + prev2) % mod;
            prev2 = prev;
            prev = curr;
        }
        return prev;
    }

    static long fTabulation(int n) {
        if (n == 0)
            return 1;
        long[] dp = new long[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % mod;
        }
        return dp[n];
    }

    static long f(int n, long[] dp) {
        if (n == 0)
            return 1;
        if (n == 1)
            return 1;
        if (dp[n] != -1)
            return dp[n];
        return dp[n] = (f(n - 1, dp) + f(n - 2, dp)) % mod;
    }
}
