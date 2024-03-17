package bfs_dfs_problems;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {

    public static void main(String[] args) {
        int[][] mat = {{2, 1, 1, 0}, {0, 1, 2, 0}, {1, 0, 1, 1}, {1, 1, 0, 0}};
        System.out.println(minTimeToRot(mat, mat.length, mat[0].length));
        System.out.println(Arrays.deepToString(mat));
    }

    static class Node {
        int i, j, time;

        Node(int i, int j, int time) {
            this.i = i;
            this.j = j;
            this.time = time;
        }
    }

    public static int minTimeToRot(int[][] grid, int n, int m) {
        int maxTime = 0;
        //By using queue
        Queue<Node> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    q.add(new Node(i, j, 0));
                }
            }
        }

        while (!q.isEmpty()) {
            Node temp = q.poll();
            int r = temp.i, c = temp.j;
            maxTime = Math.max(maxTime, temp.time);
            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    if (Math.abs(i) != Math.abs(j) && i + r >= 0 && i + r < n && j + c >= 0 && j + c < m
                            && grid[r + i][c + j] == 1) {
                        grid[r + i][c + j] = 2;
                        q.add(new Node(r + i, c + j, temp.time + 1));
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1)
                    return -1;
            }
        }
        return maxTime;
    }
}
