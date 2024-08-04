package graphs.shortest_path;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class PathWithMinimumEffort {
    static class Node {
        int maxDistAlongPath, row, col;

        public Node(int maxDistAlongPath, int row, int col) {
            this.maxDistAlongPath = maxDistAlongPath;
            this.row = row;
            this.col = col;
        }
    }

    public static void main(String[] args) {
        int[][] heights = {{1, 2, 2}, {3, 8, 2}, {5, 3, 5}};
        int r = 3, c = 3;
        System.out.println(MinimumEffort(r, c, heights));
    }

    public static int MinimumEffort(int rows, int columns, int[][] heights) {
        if (rows == 1 && columns == 1)
            return 0;
        Queue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.maxDistAlongPath));
        int[][] minDist = new int[rows][columns];
        for (int i = 0; i < minDist.length; i++) {
            Arrays.fill(minDist[i], Integer.MAX_VALUE);
        }
        minDist[0][0] = 0;
        pq.add(new Node(0, 0, 0));
        while (!pq.isEmpty()) {
            Node rem = pq.poll();
            int[] dRow = {-1, 0, 1, 0};
            int[] dCol = {0, 1, 0, -1};
            for (int i = 0; i < dRow.length; i++) {
                int nRow = rem.row + dRow[i];
                int nCol = rem.col + dCol[i];
                if (nRow >= 0 && nRow < rows && nCol >= 0 && nCol < columns) {
                    int diff = Math.abs(heights[rem.row][rem.col] - heights[nRow][nCol]);
                    int newMaxDiffAlongPath = Math.max(diff, rem.maxDistAlongPath);
                    if (newMaxDiffAlongPath < minDist[nRow][nCol]) {
                        minDist[nRow][nCol] = newMaxDiffAlongPath;
                        pq.add(new Node(newMaxDiffAlongPath, nRow, nCol));
                    }
                }
            }
        }
        return minDist[rows - 1][columns - 1];
    }
}
