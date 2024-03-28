package graphs.shortest_path_algorithms;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Point {
    int x;
    int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class ShortestPathInBinaryMaze {
    static class Node {
        int i, j, dist;

        public Node(int i, int j, int dist) {
            this.i = i;
            this.j = j;
            this.dist = dist;
        }
    }

    public static int shortestPathBinaryMatrix(int[][] matrix, Point src, Point dest) {
        if (matrix[src.x][src.y] == 0)
            return -1;
        int n = matrix.length, m = matrix[0].length;
        int[][] minDist = new int[n][m];
        for (int i = 0; i < minDist.length; i++) {
            Arrays.fill(minDist[i], Integer.MAX_VALUE);
        }
        Queue<Node> q = new LinkedList<>();

        q.add(new Node(src.x, src.y, 0));
        minDist[src.x][src.y] = 0;
        while (!q.isEmpty()) {
            Node rem = q.poll();
            if (rem.i == dest.x && rem.j == dest.y)
                return rem.dist;
            int[] drow = {-1, 0, 1, 0}, dcol = {0, 1, 0, -1};
            for (int i = 0; i < drow.length; i++) {
                int nrow = rem.i + drow[i], ncol = rem.j + dcol[i];
                if (nrow >= 0 && nrow < n &&
                        ncol >= 0 && ncol < m && matrix[nrow][ncol] == 1 &&
                        minDist[rem.i][rem.j] + 1 < minDist[nrow][ncol]) {
                    q.add(new Node(nrow, ncol, minDist[rem.i][rem.j] + 1));
                    minDist[nrow][ncol] = minDist[rem.i][rem.j] + 1;
                }
            }
        }
        return -1;
    }
}
