package dynamic_programming.two_d;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class UniquePathsII {
    static int mod = (int) (1e9 + 7);

    public static void main(String[] args) {
        int[][] mat = {{0, 0, 0}, {0, -1, 0}, {0, 0, 0}};
        ArrayList<ArrayList<Integer>> li = Arrays.stream(mat).map(arr -> Arrays.stream(arr).boxed().
                        collect(Collectors.toCollection(ArrayList::new)))
                .collect(Collectors.toCollection(ArrayList::new));
        System.out.println(mazeObstacles(mat.length, mat[0].length, li));
    }

    static int mazeObstacles(int n, int m, ArrayList<ArrayList<Integer>> mat) {
        int[][] dp = new int[n][m];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        return f(n - 1, m - 1, dp, mat);
    }

    static int f(int i, int j, int[][] dp, ArrayList<ArrayList<Integer>> mat) {
        if (i == 0 && j == 0)
            return 1;
        if (i < 0 || j < 0)
            return 0;
        if (mat.get(i).get(j) == -1)
            return 0;
        if (dp[i][j] != -1)
            return dp[i][j];
        int left = f(i, j - 1, dp, mat);
        int up = f(i - 1, j, dp, mat);
        return dp[i][j] = (left % mod + up % mod) % mod;
    }
}
