package graphs.shortest_path_algorithms;

import java.util.ArrayList;
import java.util.Arrays;

public class FloydWarshallAlgorithm {
    static int floydWarshall(int n, int m, int src, int dest, ArrayList<ArrayList<Integer>> edges) {
        int[][] mat = new int[n + 1][n + 1];
        for (int i = 0; i < n + 1; i++) {
            Arrays.fill(mat[i], (int) 1e9);
        }
        for (int i = 1; i <= n; i++) {
            mat[i][i] = 0;
        }
        for (ArrayList<Integer> edge : edges) {
            mat[edge.get(0)][edge.get(1)] = edge.get(2);
        }
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (i == k || j == k)
                        continue;
                    if (mat[i][k] != 1e9 && mat[k][j] != 1e9) {
                        mat[i][j] = Math.min(mat[i][j], mat[i][k] + mat[k][j]);
                    }
                }
            }
        }
        return mat[src][dest];
    }
}
