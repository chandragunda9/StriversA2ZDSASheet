package graphs.mst_disjoint_set;

import java.util.Arrays;
import java.util.Comparator;

public class KruskalsAlgorithm {

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

    public static int kruskalMST(int n, int[][] edges) {
        int mstWeight = 0;
        DisjointSet dis = new DisjointSet(n);
        Arrays.sort(edges, Comparator.comparingInt(e -> e[2]));
        for (int[] edge : edges) {
            if (dis.findParent(edge[0]) != dis.findParent(edge[1])) {
                dis.unionBySize(edge[0], edge[1]);
                mstWeight += edge[2];
            }
        }
        return mstWeight;
    }

    public static void main(String[] args) {
        int n = 5;
        int m = 6;
        int[][] edges = {{1, 2, 6}, {2, 3, 5}, {3, 4, 4}, {1, 4, 1}, {1, 3, 2}, {3, 5, 3}};
        System.out.println(kruskalMST(n, edges));
    }
}
