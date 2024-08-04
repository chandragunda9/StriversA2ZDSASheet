package graphs.bfs_dfs_problems;

public class ReplaceOsWithXs {
    static char[][] fill(int n, int m, char a[][]) {
        boolean[][] vis = new boolean[n][m];
        //first row
        for (int i = 0; i < m; i++) {
            if (!vis[0][i] && a[0][i] == 'O') {
                dfs(0, i, vis, a);
            }
        }
        //first col
        for (int i = 0; i < n; i++) {
            if (!vis[i][0] && a[i][0] == 'O') {
                dfs(i, 0, vis, a);
            }
        }
        //last row
        for (int i = 0; i < m; i++) {
            if (!vis[n - 1][i] && a[n - 1][i] == 'O') {
                dfs(n - 1, i, vis, a);
            }
        }
        //last col
        for (int i = 0; i < n; i++) {
            if (!vis[i][m - 1] && a[i][m - 1] == 'O') {
                dfs(i, m - 1, vis, a);
            }
        }
        for (int i = 1; i < n - 1; i++) {
            for (int j = 1; j < m - 1; j++) {
                if (!vis[i][j] && a[i][j] == 'O')
                    a[i][j] = 'X';
            }
        }
        return a;
    }

    static void dfs(int i, int j, boolean[][] vis, char[][] grid) {
        vis[i][j] = true;
        int[] dRow = {-1, 0, 1, 0};
        int[] dCol = {0, 1, 0, -1};
        for (int k = 0; k < dRow.length; k++) {
            int nRow = i + dRow[k];
            int nCol = j + dCol[k];
            if (nRow >= 0 && nRow < grid.length && nCol >= 0 && nCol < grid[0].length
                    && grid[nRow][nCol] == 'O' && !vis[nRow][nCol]) {
                dfs(nRow, nCol, vis, grid);
            }
        }
    }
}
