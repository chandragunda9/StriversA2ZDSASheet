package graphs.shortest_path;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class ShortestPathInABinaryMaze {
    static class Node {
        int i, j, cost;

        public Node(int i, int j, int cost) {
            this.i = i;
            this.j = j;
            this.cost = cost;
        }
    }

    public static void main(String[] args) {
        int[][] grid = {{1, 1, 1, 1},
                {1, 1, 0, 1},
                {1, 1, 1, 1},
                {1, 1, 0, 0},
                {1, 0, 0, 1}};
        int[] source = {0, 1}, dest = {2, 2};
        System.out.println(shortestPath(grid, source, dest));
    }

    static int shortestPath(int[][] grid, int[] source, int[] destination) {
        if (grid[source[0]][source[1]] == 0)
            return -1;
        int m = grid.length, n = grid[0].length;
        int[][] dis = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(dis[i], Integer.MAX_VALUE);
        }
        Queue<Node> q = new PriorityQueue<>(Comparator.comparingInt(a -> a.cost));
        q.add(new Node(source[0], source[1], 0));
        dis[source[0]][source[1]] = 0;
        while (!q.isEmpty()) {
            Node rem = q.poll();
            if (rem.i == destination[0] && rem.j == destination[1])
                return rem.cost;
            int[] dRow = {-1, 0, 1, 0}, dCol = {0, 1, 0, -1};
            for (int k = 0; k < dRow.length; k++) {
                int nRow = rem.i + dRow[k];
                int nCol = rem.j + dCol[k];
                if (nRow >= 0 && nRow < m && nCol >= 0 && nCol < n && grid[nRow][nCol] == 1
                        && dis[rem.i][rem.j] + 1 < dis[nRow][nCol]) {
                    q.add(new Node(nRow, nCol, dis[rem.i][rem.j] + 1));
                    dis[nRow][nCol] = dis[rem.i][rem.j] + 1;
                }
            }
        }
        return -1;
    }
}
