package graphs.bfs_dfs_problems;

public class NumberOfEnclaves {
    public static void main(String[] args) {
        int[][] grid = {{0, 0, 0, 0},
                {1, 0, 1, 0},
                {0, 1, 1, 0},
                {0, 0, 0, 0}};
        System.out.println(numberOfEnclaves(grid));
    }

    static int numberOfEnclaves(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        boolean[][] vis = new boolean[n][m];
        //first row
        for (int i = 0; i < m; i++) {
            if (!vis[0][i] && grid[0][i] == 1) {
                dfs(0, i, vis, grid);
            }
        }
        //first col
        for (int i = 0; i < n; i++) {
            if (!vis[i][0] && grid[i][0] == 1) {
                dfs(i, 0, vis, grid);
            }
        }
        //last row
        for (int i = 0; i < m; i++) {
            if (!vis[n - 1][i] && grid[n - 1][i] == 1) {
                dfs(n - 1, i, vis, grid);
            }
        }
        //last col
        for (int i = 0; i < n; i++) {
            if (!vis[i][m - 1] && grid[i][m - 1] == 1) {
                dfs(i, m - 1, vis, grid);
            }
        }
        int count = 0;
        for (int i = 1; i < n - 1; i++) {
            for (int j = 1; j < m - 1; j++) {
                if (!vis[i][j] && grid[i][j] == 1)
                    count++;
            }
        }
        return count;
    }

    static void dfs(int i, int j, boolean[][] vis, int[][] grid) {
        vis[i][j] = true;
        int[] dRow = {-1, 0, 1, 0};
        int[] dCol = {0, 1, 0, -1};
        for (int k = 0; k < dRow.length; k++) {
            int nRow = i + dRow[k];
            int nCol = j + dCol[k];
            if (nRow >= 0 && nRow < grid.length && nCol >= 0 && nCol < grid[0].length
                    && grid[nRow][nCol] == 1 && !vis[nRow][nCol]) {
                dfs(nRow, nCol, vis, grid);
            }
        }
    }
}
