package graphs.mst_disjointset;

import java.util.HashSet;
import java.util.Set;

public class MakingALargeIsland {
    static boolean isValid(int r, int c, int n) {
        return r >= 0 && r < n && c >= 0 && c < n;
    }

    public int largestIsland(int N, int[][] grid) {
        DisjointSet dis = new DisjointSet(N * N - 1);
        boolean[][] vis = new boolean[N][N];
        //step 1
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (grid[i][j] == 0 || vis[i][j])
                    continue;
                vis[i][j] = true;
                int[] dRow = {-1, 0, 1, 0}, dCol = {0, 1, 0, -1};
                for (int k = 0; k < dRow.length; k++) {
                    int nRow = i + dRow[k], nCol = j + dCol[k];
                    if (isValid(nRow, nCol, N) && grid[nRow][nCol] == 1) {
                        int nodeVal = i * N + j, adjNodeVal = nRow * N + nCol;
                        if (dis.findParent(nodeVal) != dis.findParent(adjNodeVal)) {
                            dis.unionBySize(nodeVal, adjNodeVal);
                        }
                    }
                }
            }
        }
        //step 2
        int max = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (grid[i][j] == 1)
                    continue;
                Set<Integer> comps = new HashSet<>();
                int[] dRow = {-1, 0, 1, 0}, dCol = {0, 1, 0, -1};
                for (int k = 0; k < dRow.length; k++) {
                    int nRow = i + dRow[k], nCol = j + dCol[k];
                    if (isValid(nRow, nCol, N) && grid[nRow][nCol] == 1) {
                        int adjNodeVal = nRow * N + nCol;
                        comps.add(dis.findParent(adjNodeVal));
                    }
                }
                int size = 0;
                for (Integer parent : comps) {
                    size += dis.size.get(parent);
                }
                max = Math.max(max, size + 1);
            }
        }
        // if max is 0 it means all grid values are 1's. In that case large island would be the size of the grid
        return max == 0 ? N * N : max;
    }
}
