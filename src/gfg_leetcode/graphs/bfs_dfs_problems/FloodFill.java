package gfg_leetcode.graphs.bfs_dfs_problems;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class FloodFill {
    public static void main(String[] args) {
        int[][] grid = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        int[][] ans = floodFill(grid, 1, 1, 2);
        System.out.println(Arrays.deepToString(ans));
    }

    static class Node {
        int i, j;

        Node(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    public static int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if (image[sr][sc] == color)
            return image;
        int n = image.length, m = image[0].length;
        Queue<Node> q = new LinkedList<>();
        int srcColor = image[sr][sc];
        q.add(new Node(sr, sc));
        image[sr][sc] = color;
        while (!q.isEmpty()) {
            Node rem = q.poll();
            int[] dRow = {-1, 0, 1, 0}, dCol = {0, 1, 0, -1};
            for (int i = 0; i < dRow.length; i++) {
                int nRow = rem.i + dRow[i];
                int nCol = rem.j + dCol[i];
                if (nRow >= 0 && nRow < n && nCol >= 0 && nCol < m && image[nRow][nCol] == srcColor) {
                    q.add(new Node(nRow, nCol));
                    image[nRow][nCol] = color;
                }
            }
        }
        return image;
    }
}
