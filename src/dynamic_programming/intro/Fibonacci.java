package dynamic_programming.intro;

import java.util.Arrays;
import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();

        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        //memoization
        System.out.println(fib(n, dp));
        //tabulation
        System.out.println(tabulation(n));
        //without using space
        System.out.print(tabulation2(n));
    }

    private static int fib(int n, int[] dp) {
        if (n <= 1)
            return n;
        if (dp[n] != -1)
            return dp[n];
        return dp[n] = fib(n - 1, dp) + fib(n - 2, dp);
    }

    static int tabulation(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    static int tabulation2(int n) {
        int prev2 = 0, prev = 1, curr;
        if (n == 0)
            return 0;
        for (int i = 2; i <= n; i++) {
            curr = prev2 + prev;
            prev2 = prev;
            prev = curr;
        }
        return prev;
    }
}
