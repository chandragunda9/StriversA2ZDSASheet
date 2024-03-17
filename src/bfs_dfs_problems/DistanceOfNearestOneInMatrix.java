package bfs_dfs_problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Collectors;

public class DistanceOfNearestOneInMatrix {
    static class Node {
        int r, c, distance;

        public Node(int r, int c, int distance) {
            this.r = r;
            this.c = c;
            this.distance = distance;
        }
    }

    public static ArrayList<ArrayList<Integer>> nearest(ArrayList<ArrayList<Integer>> mat, int n, int m) {
        //By using queue
        int[][] ans = new int[n][m];
        boolean[][] vis = new boolean[n][m];
        Queue<Node> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat.get(i).get(j) == 1) {
                    q.add(new Node(i, j, 0));
                    vis[i][j] = true;
                    ans[i][j] = 0;
                }
            }
        }
        while (!q.isEmpty()) {
            Node temp = q.poll();
            int ri = temp.r, ci = temp.c;
            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    if (Math.abs(i) != Math.abs(j) && ri + i >= 0 && ri + i < n &&
                            ci + j >= 0 && ci + j < m && !vis[ri + i][ci + j]) {
                        q.add(new Node(ri + i, ci + j, temp.distance + 1));
                        vis[ri + i][ci + j] = true;
                        ans[ri + i][ci + j] = temp.distance + 1;
                    }
                }
            }
        }
        return Arrays.stream(ans).map(arr -> Arrays.stream(arr).boxed()
                .collect(Collectors.toCollection(ArrayList::new))).collect(Collectors.toCollection(ArrayList::new));
    }
}
