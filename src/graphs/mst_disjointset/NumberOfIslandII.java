package graphs.mst_disjointset;

import java.util.ArrayList;
import java.util.List;

public class NumberOfIslandII {
    public static void main(String[] args) {
        int rows = 4, cols = 5;
        int[][] queries = {{1, 1}, {0, 1}, {3, 3}, {3, 4}};
        System.out.println(numOfIslands(rows, cols, queries));
    }

    public static List<Integer> numOfIslands(int rows, int cols, int[][] operators) {
        List<Integer> ans = new ArrayList<>();
        DisjointSet dis = new DisjointSet(rows * cols);
        boolean[][] vis = new boolean[rows][cols];
        int count = 0;
        for (int i = 0; i < operators.length; i++) {
            int[] query = operators[i];
            int row = query[0], col = query[1];
            if (vis[row][col]) {
                ans.add(count);
                continue;
            }
            vis[row][col] = true;
            count++;
            int[] dRow = {-1, 0, 1, 0};
            int[] dCol = {0, 1, 0, -1};
            for (int j = 0; j < dRow.length; j++) {
                int nRow = row + dRow[j];
                int nCol = col + dCol[j];
                if (nRow >= 0 && nRow < rows && nCol >= 0 && nCol < cols
                        && vis[nRow][nCol]) {
                    int nodeVal = row * cols + col;
                    int adjNodeVal = nRow * cols + nCol;
                    if (dis.findParent(nodeVal) != dis.findParent(adjNodeVal)) {
                        dis.unionBySize(nodeVal, adjNodeVal);
                        count--;
                    }
                }
            }
            ans.add(count);
        }
        return ans;
    }
}
