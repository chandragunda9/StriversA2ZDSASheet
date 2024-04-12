package graphs.mst_disjoint_set;

public class MostStonesRemoved {

    public static class DisjointSet {
        int[] parents;
        int[] sizes;

        public DisjointSet(int n) {
            parents = new int[n + 1];
            sizes = new int[n + 1];
            for (int i = 0; i <= n; i++) {
                parents[i] = i;
                sizes[i] = 1;
            }
        }

        public int findParent(int node) {
            if (node == parents[node]) {
                return node;
            }
            return parents[node] = findParent(parents[node]);
        }

        public void unionBySize(int x, int y) {
            int rootX = findParent(x);
            int rootY = findParent(y);
            if (rootX == rootY)
                return;
            if (sizes[rootX] < sizes[rootY]) {
                parents[rootX] = rootY;
                sizes[rootY] += sizes[rootX];
            } else {
                parents[rootY] = rootX;
                sizes[rootX] += sizes[rootY];
            }
        }
    }

    public static int removeStones(int[][] stones) {
        int maxRow = 0, maxCol = 0;
        for (int[] stone : stones) {
            maxRow = Math.max(maxRow, stone[0]);
            maxCol = Math.max(maxCol, stone[1]);
        }
        int n = maxRow + maxCol + 2;
        DisjointSet dis = new DisjointSet(n);
        for (int[] stone : stones) {
            int nodeRow = stone[0];
            int nodeCol = stone[1] + maxRow + 1;
            dis.unionBySize(nodeRow, nodeCol);
        }

        int noOfComponents = 0;
        for (int i = 0; i <= n; i++) {
            if (dis.findParent(i) == i && dis.sizes[i] > 1)
                noOfComponents++;
        }
        return stones.length - noOfComponents;
    }
}
