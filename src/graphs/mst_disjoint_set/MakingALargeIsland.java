package graphs.mst_disjoint_set;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MakingALargeIsland {
    static class DisjointSet {
        int[] parent;
        int[] sizes;

        public DisjointSet(int n) {
            parent = new int[n + 1];
            sizes = new int[n + 1];
            Arrays.fill(sizes, 1);
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
            if (rootX == rootY)
                return;
            if (sizes[rootX] < sizes[rootY]) {
                parent[rootX] = rootY;
                sizes[rootY] += sizes[rootX];
            } else {
                parent[rootY] = rootX;
                sizes[rootX] += sizes[rootY];
            }
        }
    }

    public static int maximumIslandSize(int[][] grid) {
        int n = grid.length, m = grid[0].length, numNodes = n * m;

        DisjointSet dis = new DisjointSet(numNodes);

        //step-1 : making connected
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++) {
                if (grid[row][col] == 0)
                    continue;
                int[] drow = {-1, 0, 1, 0}, dcol = {0, 1, 0, -1};
                for (int k = 0; k < drow.length; k++) {
                    int adjRow = row + drow[k], adjCol = col + dcol[k];
                    if (adjRow >= 0 && adjRow < n && adjCol >= 0 && adjCol < m) {
                        if (grid[adjRow][adjCol] == 1) {
                            int nodeNo = row * m + col, adjNodeNo = adjRow * m + adjCol;
                            dis.unionBySize(nodeNo, adjNodeNo);
                        }
                    }
                }
            }
        }

        int maxSize = 0;
        //step 2
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++) {
                if (grid[row][col] == 1)
                    continue;
                int[] drow = {-1, 0, 1, 0}, dcol = {0, 1, 0, -1};
                Set<Integer> components = new HashSet<>();
                for (int k = 0; k < drow.length; k++) {
                    int adjRow = row + drow[k], adjCol = col + dcol[k];
                    if (adjRow >= 0 && adjRow < n && adjCol >= 0 && adjCol < m) {
                        if (grid[adjRow][adjCol] == 1) {
                            int adjNodeNo = adjRow * m + adjCol;
                            components.add(dis.findUParent(adjNodeNo));
                        }
                    }
                }
                int size = 0;
                for (Integer parent : components) {
                    size += dis.sizes[parent];
                }
                maxSize = Math.max(maxSize, size + 1);
            }
        }
        for (int cellNo = 0; cellNo < numNodes; cellNo++) {
            maxSize = Math.max(maxSize, dis.sizes[dis.findUParent(cellNo)]);
        }
        return maxSize;
    }

    public static void main(String[] args) {
        int[][] ma = {{0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}};
        System.out.print(maximumIslandSize(ma));
    }
}
