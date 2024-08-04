package graphs.shortest_path;

import java.util.Arrays;

public class FloydWarshallAlgorithm {
    public static void main(String[] args) {
        int[][] mat = {{0, 1, 43}, {1, 0, 6}, {-1, -1, 0}};
        shortest_distance(mat);
        System.out.println(Arrays.deepToString(mat));
    }

    public static void shortest_distance(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == -1)
                    matrix[i][j] = Integer.MAX_VALUE;
            }
        }
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (matrix[i][k] != Integer.MAX_VALUE && matrix[k][j] != Integer.MAX_VALUE) {
                        matrix[i][j] = Math.min(matrix[i][j], matrix[i][k] + matrix[k][j]);
                    }
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == Integer.MAX_VALUE)
                    matrix[i][j] = -1;
            }
        }
    }
}
