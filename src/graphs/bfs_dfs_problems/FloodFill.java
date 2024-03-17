package graphs.bfs_dfs_problems;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class FloodFill {
    public static void main(String[] args) {
        int[][] mat = {{7, 1, 1, 1}
                , {1, 7, 7, 7}
                , {7, 7, 7, 0}
                , {7, 7, 7, 4}
                , {4, 4, 4, 4}};
        int x = 2, y = 2;
        int pixelValue = 5;
        System.out.println(Arrays.deepToString(floodFill(mat, mat.length, mat[0].length, x, y, pixelValue)));
    }

    static class Node {
        int i, j;

        public Node(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    public static int[][] floodFill(int[][] image, int n, int m, int x, int y, int p) {
        int cp = image[x][y];
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(x, y));
        image[x][y] = p;
        while (!q.isEmpty()) {
            Node temp = q.poll();
            int r = temp.i, c = temp.j;
            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    if (Math.abs(i) != Math.abs(j) && r + i >= 0 && r + i < n &&
                            c + j >= 0 && c + j < m && image[r + i][c + j] == cp) {
                        image[r + i][c + j] = p;
                        q.add(new Node(r + i, c + j));
                    }
                }
            }
        }
        return image;
    }
}
