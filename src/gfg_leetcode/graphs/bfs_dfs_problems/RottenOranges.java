package gfg_leetcode.graphs.bfs_dfs_problems;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {
    public static void main(String[] args) {
        int[][] mat = {{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
        System.out.println(orangesRotting(mat));
    }

    static class Node {
        int i, j, time;

        Node(int i, int j, int time) {
            this.i = i;
            this.j = j;
            this.time = time;
        }
    }

    public static int orangesRotting(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        Queue<Node> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    q.add(new Node(i, j, 0));
                }
            }
        }

        int ans = 0;
        while (!q.isEmpty()) {
            Node rem = q.poll();
            int i = rem.i, j = rem.j;
            ans = Math.max(ans, rem.time);
            int[] dRow = {-1, 0, 1, 0}, dCol = {0, 1, 0, -1};
            for (int k = 0; k < dRow.length; k++) {
                int nRow = i + dRow[k];
                int nCol = j + dCol[k];
                if (nRow >= 0 && nRow < n && nCol >= 0 && nCol < m && grid[nRow][nCol] == 1) {
                    grid[nRow][nCol] = 2;
                    q.add(new Node(nRow, nCol, rem.time + 1));
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1)
                    return -1;
            }
        }
        return ans;
    }
}
