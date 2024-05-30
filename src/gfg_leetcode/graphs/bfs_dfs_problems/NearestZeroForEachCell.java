package gfg_leetcode.graphs.bfs_dfs_problems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class NearestZeroForEachCell {
    static class Node {
        int i, j, dist;

        public Node(int i, int j, int dist) {
            this.i = i;
            this.j = j;
            this.dist = dist;
        }
    }

    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length, m = mat[0].length;
        int[][] ans = new int[n][m];
        boolean[][] vis = new boolean[n][m];

        Queue<Node> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 0) {
                    q.add(new Node(i, j, 0));
                    vis[i][j] = true;
                    ans[i][j] = 0;
                }
            }
        }

        while (!q.isEmpty()) {
            Node rem = q.poll();
            int[] dRow = {-1, 0, 1, 0};
            int[] dCol = {0, 1, 0, -1};
            for (int i = 0; i < dRow.length; i++) {
                int nRow = rem.i + dRow[i];
                int nCol = rem.j + dCol[i];
                if (nRow >= 0 && nRow < n && nCol >= 0 && nCol < m && !vis[nRow][nCol]) {
                    q.add(new Node(nRow, nCol, rem.dist + 1));
                    vis[nRow][nCol] = true;
                    ans[nRow][nCol] = rem.dist + 1;
                }
            }
        }
        return ans;
    }
}
