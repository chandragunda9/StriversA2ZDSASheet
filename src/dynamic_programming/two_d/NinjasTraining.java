package dynamic_programming.two_d;

import java.util.Arrays;

public class NinjasTraining {
    public static void main(String[] args) {
//        int[][] arr = {{1, 2, 5}, {3, 1, 1}, {3, 3, 3}};
        int[][] arr = {{10, 40, 70}, {20, 50, 80}, {30, 60, 90}};
        System.out.println(ninjaTraining(arr.length, arr));
    }

    public static int ninjaTraining(int n, int[][] points) {
        int[][] dp = new int[n][4];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        return f(n - 1, 3, points, dp);
    }

    static int f(int dayIndex, int lastTaskChosen, int[][] points, int[][] dp) {
        if (dayIndex == 0) {
            int maxi = 0;
            for (int taskInd = 0; taskInd < 3; taskInd++) {
                if (taskInd != lastTaskChosen) {
                    maxi = Math.max(maxi, points[dayIndex][taskInd]);
                }
            }
            return dp[dayIndex][lastTaskChosen] = maxi;
        }
        if (dp[dayIndex][lastTaskChosen] != -1)
            return dp[dayIndex][lastTaskChosen];
        int maxi = 0;
        for (int i = 0; i < 3; i++) {
            if (i != lastTaskChosen) {
                int point = points[dayIndex][i] + f(dayIndex - 1, i, points, dp);
                maxi = Math.max(maxi, point);
            }
        }
        return dp[dayIndex][lastTaskChosen] = maxi;
    }
}
