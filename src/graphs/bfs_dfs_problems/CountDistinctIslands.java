package graphs.bfs_dfs_problems;

import java.util.*;

public class CountDistinctIslands {
    public static void main(String[] args) {
//        Set<List<List<Integer>>> s = new HashSet<>();
//        List<Integer> a1 = new ArrayList<>(Arrays.asList(1, 2, 3));
//        List<Integer> a2 = new ArrayList<>(Arrays.asList(4, 5, 6));
//        List<Integer> b1 = new ArrayList<>(Arrays.asList(1, 2, 3));
//        List<Integer> b2 = new ArrayList<>(Arrays.asList(4, 5, 6));
//        List<List<Integer>> a = new ArrayList<>();
//        List<List<Integer>> b = new ArrayList<>();
//        a.add(a1);
//        a.add(a2);
//        b.add(b1);
//        b.add(b2);
//        s.add(a);
//        s.add(b);
//        System.out.println(s);
        int[][] arr = {{1, 1, 0, 1, 1},
                {1, 0, 0, 0, 0},
                {0, 0, 0, 0, 1},
                {1, 1, 0, 1, 1}};
        System.out.println(distinctIsland(arr, arr.length, arr[0].length));
    }

    public static int distinctIsland(int[][] arr, int n, int m) {
        Set<List<List<Integer>>> ans = new HashSet<>();
        boolean[][] vis = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!vis[i][j] && arr[i][j] == 1) {
                    List<List<Integer>> oneDfs = new ArrayList<>();
                    dfs(arr, n, m, i, j, i, j, vis, oneDfs);
                    ans.add(oneDfs);
                }
            }
        }
        return ans.size();
    }

    static void dfs(int[][] arr, int n, int m, int currI, int currJ, int baseI, int baseJ,
                    boolean[][] vis, List<List<Integer>> oneDfs) {
        vis[currI][currJ] = true;
        oneDfs.add(new ArrayList<>(Arrays.asList(currI - baseI, currJ - baseJ)));
        int[] rowOffset = {0, -1, 0, 1};
        int[] colOffset = {1, 0, -1, 0};
        for (int i = 0; i < 4; i++) {
            int nrow = currI + rowOffset[i], ncol = currJ + colOffset[i];
            if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m &&
                    arr[nrow][ncol] == 1 && !vis[nrow][ncol]) {
                dfs(arr, n, m, nrow, ncol, baseI, baseJ, vis, oneDfs);
            }
        }
    }
}
