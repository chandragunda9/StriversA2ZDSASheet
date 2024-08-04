package graphs.bfs_dfs_problems;

import java.util.LinkedList;
import java.util.Queue;

class Node {
    int i, j;
    int time;

    public Node(int i, int j, int time) {
        this.i = i;
        this.j = j;
        this.time = time;
    }
    public Node(int i, int j) {
        this.i = i;
        this.j = j;
    }
}

public class RottenOranges {
    public static void main(String[] args) {
//        int[][] grid = {{0, 1, 2}, {0, 1, 2}, {2, 1, 1}};
        int[][] grid = {{2, 2, 0, 1}};
        System.out.println(orangesRotting(grid));
    }

    public static int orangesRotting(int[][] grid) {
        Queue<Node> q = new LinkedList<>();
        int ans = 0;

        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    q.add(new Node(i, j, 0));
                }
            }
        }
        while (!q.isEmpty()) {
            Node rem = q.poll();
            ans = Math.max(ans, rem.time);
            int[] dRow = {-1, 0, 1, 0};
            int[] dCol = {0, 1, 0, -1};
            for (int k = 0; k < dRow.length; k++) {
                int nRow = rem.i + dRow[k];
                int nCol = rem.j + dCol[k];
                if (nRow >= 0 && nRow < m && nCol >= 0 && nCol < n &&
                        grid[nRow][nCol] == 1) {
                    q.add(new Node(nRow, nCol, rem.time + 1));
                    grid[nRow][nCol] = 2;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1)
                    return -1;
            }
        }
        return ans;
    }
}
