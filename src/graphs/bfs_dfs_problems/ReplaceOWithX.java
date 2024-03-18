package graphs.bfs_dfs_problems;

import java.util.Arrays;

public class ReplaceOWithX {
    public static void main(String[] args) {
        char[][] mat = {{'X', 'O', 'X', 'X', 'O', 'X', 'X', 'X', 'X', 'O'},
                {'X', 'O', 'O', 'X', 'X', 'O', 'X', 'O', 'X', 'X'},
                {'X', 'O', 'X', 'O', 'O', 'O', 'O', 'O', 'X', 'X'},
                {'O', 'O', 'X', 'X', 'X', 'X', 'X', 'X', 'O', 'O'},
                {'X', 'X', 'O', 'X', 'O', 'O', 'X', 'X', 'X', 'X'},
                {'X', 'X', 'X', 'X', 'X', 'X', 'O', 'O', 'O', 'X'},
                {'X', 'O', 'O', 'X', 'O', 'O', 'X', 'X', 'X', 'O'},
                {'X', 'O', 'X', 'X', 'O', 'O', 'O', 'X', 'O', 'X'},
                {'O', 'X', 'X', 'X', 'X', 'X', 'O', 'O', 'O', 'X'},
                {'X', 'O', 'O', 'X', 'O', 'O', 'X', 'X', 'X', 'O'}};
        replaceOWithX(mat);
        System.out.println(Arrays.deepToString(mat));
    }

    public static void replaceOWithX(char matrix[][]) {
        int n = matrix.length, m = matrix[0].length;
        boolean[][] vis = new boolean[n][m];
        //first row
        for (int j = 0; j < m; j++) {
            if (!vis[0][j] && matrix[0][j] == 'O') {
                dfs(matrix, 0, j, vis);
            }
        }
        //first column
        for (int i = 0; i < n; i++) {
            if (!vis[i][0] && matrix[i][0] == 'O') {
                dfs(matrix, i, 0, vis);
            }
        }
        //last row
        for (int j = 0; j < m; j++) {
            if (!vis[n - 1][j] && matrix[n - 1][j] == 'O') {
                dfs(matrix, n - 1, j, vis);
            }
        }
        //last column
        for (int i = 0; i < n; i++) {
            if (!vis[i][m - 1] && matrix[i][m - 1] == 'O') {
                dfs(matrix, i, m - 1, vis);
            }
        }
        //replace O with X
        for (int i = 1; i < n - 1; i++) {
            for (int j = 1; j < m - 1; j++) {
                if (!vis[i][j] && matrix[i][j] == 'O')
                    matrix[i][j] = 'X';
            }
        }
    }

    static void dfs(char[][] mat, int ri, int ci, boolean[][] vis) {
        int n = mat.length, m = mat[0].length;
        vis[ri][ci] = true;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                int ni = ri + i, nj = ci + j;
                if (Math.abs(i) != Math.abs(j) && ni >= 0 && ni < n && nj >= 0 && nj < m &&
                        !vis[ni][nj] && mat[ni][nj] == 'O') {
                    dfs(mat, ni, nj, vis);
                }
            }
        }
    }
}
