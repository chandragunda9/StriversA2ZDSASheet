package gfg_leetcode.graphs.bfs_dfs_problems;

public class SurroundedRegions {
    public void solve(char[][] board) {
        int n = board.length, m = board[0].length;
        boolean[][] vis = new boolean[n][m];
        //first row
        for (int i = 0; i < m; i++) {
            if (!vis[0][i] && board[0][i] == 'O')
                dfs(0, i, vis, board);
        }
        //first col
        for (int i = 0; i < n; i++) {
            if (!vis[i][0] && board[i][0] == 'O')
                dfs(i, 0, vis, board);
        }
        //last row
        for (int i = 0; i < m; i++) {
            if (!vis[n - 1][i] && board[n - 1][i] == 'O')
                dfs(n - 1, i, vis, board);
        }
        //last col
        for (int i = 0; i < n; i++) {
            if (!vis[i][m - 1] && board[i][m - 1] == 'O')
                dfs(i, m - 1, vis, board);
        }
        //replace 0 with X
        for (int i = 1; i < n - 1; i++) {
            for (int j = 1; j < m - 1; j++) {
                if (!vis[i][j] && board[i][j] == 'O')
                    board[i][j] = 'X';
            }
        }
    }

    static void dfs(int i, int j, boolean[][] vis, char[][] board) {
        vis[i][j] = true;
        int[] dRow = {-1, 0, 1, 0};
        int[] dCol = {0, 1, 0, -1};
        for (int k = 0; k < dRow.length; k++) {
            int nRow = i + dRow[k];
            int nCol = j + dCol[k];
            if (nRow >= 0 && nRow < board.length && nCol >= 0 && nCol < board[0].length
                    && board[nRow][nCol] == 'O' && !vis[nRow][nCol]) {
                dfs(nRow, nCol, vis, board);
            }
        }
    }
}
