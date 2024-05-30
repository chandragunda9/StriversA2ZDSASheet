package gfg_leetcode.graphs.bfs_dfs_problems;

public class NumIslands {
    public static void main(String[] args) {
        char[][] grid = {{'0', '1'}, {'1', '0'}, {'1', '1'}, {'1', '0'}};
        System.out.println(numIslands(grid));
    }

    public static int numIslands(char[][] grid) {
        int n = grid.length, m = grid[0].length;
        boolean[][] vis = new boolean[n][m];
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!vis[i][j] && grid[i][j] == '1') {
                    dfs(i, j, vis, grid);
                    count++;
                }
            }
        }
        return count;
    }

    static void dfs(int r, int c, boolean[][] vis, char[][] grid) {
        vis[r][c] = true;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0)
                    continue;
                int nRow = r + i;
                int nCol = c + j;
                if (nRow >= 0 && nRow < grid.length &&
                        nCol >= 0 && nCol < grid[0].length &&
                        !vis[nRow][nCol] && grid[nRow][nCol] == '1') {
                    dfs(nRow, nCol, vis, grid);
                }
            }
        }
    }
}
