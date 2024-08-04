package graphs.bfs_dfs_problems;

import java.util.*;

public class NumberOfDistinctIslands {
    public static void main(String[] args) {
        int[][] grid = {{1, 1, 0, 0, 0},
                {1, 1, 0, 0, 0},
                {0, 0, 0, 1, 1},
                {0, 0, 0, 1, 1}};
        System.out.print(countDistinctIslands(grid));
    }

    static int countDistinctIslands(int[][] grid) {
        Set<List<List<Integer>>> ans = new HashSet<>();
        int m = grid.length, n = grid[0].length;
        boolean[][] vis = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && !vis[i][j]) {
                    List<List<Integer>> traversal = new ArrayList<>();
                    dfs(i, j, i, j, vis, grid, traversal);
                    ans.add(traversal);
                }
            }
        }
        return ans.size();
    }

    static void dfs(int currI, int currJ, int baseI, int baseJ, boolean[][] vis,
                    int[][] grid, List<List<Integer>> traversal) {
        vis[currI][currJ] = true;
        traversal.add(new ArrayList<>(Arrays.asList(currI - baseI, currJ - baseJ)));
        int[] dRow = {-1, 0, 1, 0};
        int[] dCol = {0, 1, 0, -1};
        for (int i = 0; i < dRow.length; i++) {
            int nRow = currI + dRow[i], nCol = currJ + dCol[i];
            if (nRow >= 0 && nRow < grid.length && nCol >= 0 && nCol < grid[0].length
                    && grid[nRow][nCol] == 1 && !vis[nRow][nCol]) {
                dfs(nRow, nCol, baseI, baseJ, vis, grid, traversal);
            }
        }
    }
}
