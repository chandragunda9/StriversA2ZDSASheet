package graphs.bfs_dfs_problems;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class DistanceOfNearestOne {
    static class Node {
        int i, j, dist;

        public Node(int i, int j, int dist) {
            this.i = i;
            this.j = j;
            this.dist = dist;
        }
    }

    public static void main(String[] args) {
        int[][] grid = {{1, 0, 1}, {1, 1, 0}, {1, 0, 0}};
        System.out.println(Arrays.deepToString(nearest(grid)));
    }

    public static int[][] nearest(int[][] grid) {
        Queue<Node> q = new LinkedList<>();
        int m = grid.length, n = grid[0].length;
        int[][] ans = new int[m][n];
        boolean[][] vis = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    q.add(new Node(i, j, 0));
                    vis[i][j] = true;
                }
            }
        }
        while (!q.isEmpty()) {
            Node rem = q.poll();
            ans[rem.i][rem.j] = rem.dist;
            int[] dRow = {-1, 0, 1, 0}, dCol = {0, 1, 0, -1};
            for (int k = 0; k < dRow.length; k++) {
                int nRow = rem.i + dRow[k], nCol = rem.j + dCol[k];
                if (nRow >= 0 && nRow < m && nCol >= 0 && nCol < n && !vis[nRow][nCol]) {
                    q.add(new Node(nRow, nCol, rem.dist + 1));
                    vis[nRow][nCol] = true;
                }
            }
        }
        return ans;
    }
}
