package graphs.bfs_dfs_problems;

public class MatrixTraps {
    public static void main(String[] args) {
        int[][] mat = {{1, 1, 0, 1}, {0, 1, 0, 1}, {1, 0, 1, 0}, {1, 0, 1, 1}, {0, 1, 0, 1}};
        System.out.println(matrixTraps(mat.length, mat[0].length, mat));
    }

    public static int matrixTraps(int n, int m, int[][] matrix) {
        boolean[][] vis = new boolean[n][m];
        //first row
        for (int j = 0; j < m; j++) {
            if (!vis[0][j] && matrix[0][j] == 0) {
                dfs(matrix, 0, j, vis);
            }
        }
        //first column
        for (int i = 0; i < n; i++) {
            if (!vis[i][0] && matrix[i][0] == 0) {
                dfs(matrix, i, 0, vis);
            }
        }
        //last row
        for (int j = 0; j < m; j++) {
            if (!vis[n - 1][j] && matrix[n - 1][j] == 0) {
                dfs(matrix, n - 1, j, vis);
            }
        }
        //last column
        for (int i = 0; i < n; i++) {
            if (!vis[i][m - 1] && matrix[i][m - 1] == 0) {
                dfs(matrix, i, m - 1, vis);
            }
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!vis[i][j] && matrix[i][j] == 0)
                    count++;
            }
        }
        return count;
    }

    static void dfs(int[][] mat, int ri, int ci, boolean[][] vis) {
        int n = mat.length, m = mat[0].length;
        vis[ri][ci] = true;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                int ni = ri + i, nj = ci + j;
                if (Math.abs(i) != Math.abs(j) && ni >= 0 && ni < n && nj >= 0 && nj < m &&
                        !vis[ni][nj] && mat[ni][nj] == 0) {
                    dfs(mat, ni, nj, vis);
                }
            }
        }
    }

    public int numEnclaves(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        boolean[][] vis = new boolean[n][m];
        //first row
        for (int j = 0; j < m; j++) {
            if (!vis[0][j] && grid[0][j] == 0) {
                dfs(grid, 0, j, vis);
            }
        }
        //first column
        for (int i = 0; i < n; i++) {
            if (!vis[i][0] && grid[i][0] == 0) {
                dfs(grid, i, 0, vis);
            }
        }
        //last row
        for (int j = 0; j < m; j++) {
            if (!vis[n - 1][j] && grid[n - 1][j] == 0) {
                dfs(grid, n - 1, j, vis);
            }
        }
        //last column
        for (int i = 0; i < n; i++) {
            if (!vis[i][m - 1] && grid[i][m - 1] == 0) {
                dfs(grid, i, m - 1, vis);
            }
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!vis[i][j] && grid[i][j] == 0)
                    count++;
            }
        }
        return count;
    }
}
