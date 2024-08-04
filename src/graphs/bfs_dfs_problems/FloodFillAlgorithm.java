package graphs.bfs_dfs_problems;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class FloodFillAlgorithm {
    public static void main(String[] args) {
        int[][] mat = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        int sr = 1, sc = 1, newColor = 2;
        System.out.println(Arrays.deepToString(floodFill(mat, sr, sc, newColor)));
    }

    public static int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if (image[sr][sc] == color)
            return image;
        int m = image.length, n = image[0].length;
        int srcColor = image[sr][sc];
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(sr, sc));
        image[sr][sc] = color;
        while (!q.isEmpty()) {
            Node rem = q.poll();
            int[] dRow = {-1, 0, 1, 0};
            int[] dCol = {0, 1, 0, -1};
            for (int k = 0; k < dRow.length; k++) {
                int nRow = rem.i + dRow[k];
                int nCol = rem.j + dCol[k];
                if (nRow >= 0 && nRow < m && nCol >= 0 && nCol < n && image[nRow][nCol] == srcColor) {
                    image[nRow][nCol] = color;
                    q.add(new Node(nRow, nCol));
                }
            }
        }
        return image;
    }
}
