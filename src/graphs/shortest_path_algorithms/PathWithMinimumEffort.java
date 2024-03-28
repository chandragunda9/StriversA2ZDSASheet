package graphs.shortest_path_algorithms;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class PathWithMinimumEffort {
    static class Node {
        int diff, row, col;

        public Node(int diff, int row, int col) {
            this.diff = diff;
            this.row = row;
            this.col = col;
        }
    }

    public static void main(String[] args) {
        int[][] heights = {{1, 8, 8}, {3, 8, 9}, {5, 3, 5}};
        System.out.println(minimumTimeTakingPath(heights));
    }

    public static int minimumTimeTakingPath(int[][] heights) {
        int n = heights.length, m = heights[0].length;
        int[][] dist = new int[n][m];
        int[] drow = {-1, 0, 1, 0}, dcol = {0, 1, 0, -1};
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        dist[0][0] = 0;
        Queue<Node> q = new PriorityQueue<>(Comparator.comparingInt(a -> a.diff));
        q.add(new Node(0, 0, 0));
        while (!q.isEmpty()) {
            Node rem = q.poll();
            if (rem.row == n - 1 && rem.col == m - 1)
                return rem.diff;
            for (int i = 0; i < drow.length; i++) {
                int maxDiff = rem.diff, nrow = rem.row + drow[i], ncol = rem.col + dcol[i];
                if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m) {
                    int newDiff = Math.abs(heights[rem.row][rem.col] - heights[nrow][ncol]);
                    maxDiff = Math.max(maxDiff, newDiff);
                    if (maxDiff < dist[nrow][ncol]) {
                        q.add(new Node(maxDiff, nrow, ncol));
                        dist[nrow][ncol] = maxDiff;
                    }
                }
            }
        }
        return 0;
    }
}
