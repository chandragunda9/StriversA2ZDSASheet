package graphs.shortest_path;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestSourceToDestinationPath {
    static class Pair {
        int cost, i, j;

        public Pair(int cost, int i, int j) {
            this.cost = cost;
            this.i = i;
            this.j = j;
        }
    }

    public static void main(String[] args) {
        int[][] mat = {{1, 0, 0, 0},
                {1, 1, 0, 1},
                {0, 1, 1, 1}};
        int x = 2, y = 3;
        System.out.println(shortestDistance(mat.length, mat[0].length, mat, x, y));
    }

    static int shortestDistance(int N, int M, int A[][], int X, int Y) {
        if (A[0][0] == 0)
            return -1;
//        Queue<Pair> q = new PriorityQueue<>(Comparator.comparingInt(a -> a.cost));
        Queue<Pair> q = new LinkedList<>();
        int[][] dist = new int[N][M];
        for (int i = 0; i < N; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        q.add(new Pair(0, 0, 0));
        dist[0][0] = 0;
        while (!q.isEmpty()) {
            Pair rem = q.poll();
            if (rem.i == X && rem.j == Y)
                return dist[rem.i][rem.j];
            int[] dRow = {-1, 0, 1, 0}, dCol = {0, 1, 0, -1};
            for (int k = 0; k < dRow.length; k++) {
                int nRow = rem.i + dRow[k], nCol = rem.j + dCol[k];
                if (nRow >= 0 && nRow < N && nCol >= 0 && nCol < M && A[nRow][nCol] == 1
                        && dist[rem.i][rem.j] + 1 < dist[nRow][nCol]) {
                    dist[nRow][nCol] = dist[rem.i][rem.j] + 1;
                    q.add(new Pair(dist[nRow][nCol], nRow, nCol));
                }
            }
        }
        return -1;
    }
}
