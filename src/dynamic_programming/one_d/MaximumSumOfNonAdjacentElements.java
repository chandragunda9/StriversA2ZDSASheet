package dynamic_programming.one_d;

import java.util.ArrayList;
import java.util.Arrays;

public class MaximumSumOfNonAdjacentElements {
    public static void main(String[] args) {
        int n = 4;
        ArrayList<Integer> al = new ArrayList<>(Arrays.asList(2, 1, 4, 9));
        System.out.print(maximumNonAdjacentSum(al));
    }

    public static int maximumNonAdjacentSum(ArrayList<Integer> nums) {
        //maintaining sums of elements up to that index
        int[] dp = new int[nums.size()];
        Arrays.fill(dp, -1);
//        return f(nums.size() - 1, nums, dp);
//        return f1(0, nums, dp);

        //tabulation method
        return tab(nums, dp);
    }

    static int tab(ArrayList<Integer> nums, int[] dp) {
        //storing maxsums upto that index
        if (nums.size() == 1)
            return nums.get(0);
        dp[0] = nums.get(0);
        dp[1] = Math.max(nums.get(0), nums.get(1));
        for (int i = 2; i < nums.size(); i++) {
            //takecase
            int take = nums.get(i) + dp[i - 2];
            int nottake = dp[i - 1];  //0+dp[i-1]
            dp[i] = Math.max(take, nottake);
        }
        return dp[nums.size() - 1];
    }

    static int f(int ind, ArrayList<Integer> nums, int[] dp) {
        if (ind < 0)
            return 0;
        if (dp[ind] != -1)
            return dp[ind];
        int pickSum = nums.get(ind) + f(ind - 2, nums, dp);
        int notPickSum = f(ind - 1, nums, dp);
        return dp[ind] = Math.max(pickSum, notPickSum);
    }

    static int f1(int ind, ArrayList<Integer> nums, int[] dp) {
        if (ind >= nums.size())
            return 0;
        if (dp[ind] != -1)
            return dp[ind];
        int pickSum = nums.get(ind) + f1(ind + 2, nums, dp);
        int notPickSum = f1(ind + 1, nums, dp);
        return dp[ind] = Math.max(pickSum, notPickSum);
    }
}
