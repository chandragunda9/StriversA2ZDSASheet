package graphs.mst_disjoint_set;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumberOfIslandsII {
    static class DisjointSet {
        int[] parent;
        int[] size;

        public DisjointSet(int n) {
            parent = new int[n];
            size = new int[n];
            Arrays.fill(size, 1);
            for (int i = 0; i < parent.length; i++) {
                parent[i] = i;
            }
        }

        public int findUParent(int node) {
            if (node == parent[node])
                return node;
            return parent[node] = findUParent(parent[node]);
        }

        public void unionBySize(int u, int v) {
            int rootX = findUParent(u);
            int rootY = findUParent(v);
            if (size[rootX] < size[rootY]) {
                parent[rootX] = rootY;
                size[rootY] += size[rootX];
            } else {
                parent[rootY] = rootX;
                size[rootX] += size[rootY];
            }
        }
    }

    public static int[] numberOfIslandII(int n, int m, int[][] queries, int q) {
        int count = 0;
        List<Integer> ans = new ArrayList<>();
        boolean[][] vis = new boolean[n][m];

        int numOfNodes = n * m;
        DisjointSet dis = new DisjointSet(numOfNodes);

        for (int[] each : queries) {
            int row = each[0], col = each[1];
            if (vis[row][col]) {
                ans.add(count);
                continue;
            }
            vis[row][col] = true;
            count++;
            int[] drow = {-1, 0, 1, 0}, dcol = {0, 1, 0, -1};
            for (int i = 0; i < drow.length; i++) {
                int adjRow = row + drow[i];
                int adjCol = col + dcol[i];
                if (adjRow >= 0 && adjRow < n && adjCol >= 0 && adjCol < m) {
                    if (vis[adjRow][adjCol]) {
                        int nodeNo = row * m + col;
                        int adjNodeNo = adjRow * m + adjCol;
                        if (dis.findUParent(nodeNo) != dis.findUParent(adjNodeNo)) {
                            count--;
                            dis.unionBySize(nodeNo, adjNodeNo);
                        }
                    }
                }
            }
            ans.add(count);
        }
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        int[][] arr = {{1, 1}, {1, 2}, {2, 3}};
        int n = 3, m = 4;
        System.out.print(Arrays.toString(numberOfIslandII(n, m, arr, args.length)));
    }
}
