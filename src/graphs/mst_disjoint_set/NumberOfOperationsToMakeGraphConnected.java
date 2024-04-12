package graphs.mst_disjoint_set;

import java.util.ArrayList;

public class NumberOfOperationsToMakeGraphConnected {

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

    public static int makeGraphConnected(int n, ArrayList<ArrayList<Integer>> edges, int m) {
        DisjointSet dis = new DisjointSet(n);
        int extraEdges = 0;
        for (ArrayList<Integer> edge : edges) {
            if (dis.findParent(edge.get(0)) != dis.findParent(edge.get(1))) {
                dis.unionBySize(edge.get(0), edge.get(1));
            } else {
                extraEdges++;
            }
        }
        int noOfComponents = 0;
        for (int i = 1; i <= n; i++) {
            if (dis.parents[i] == i)
                noOfComponents++;
        }
        int noOfEdgesNeed = noOfComponents - 1;
        if (extraEdges >= noOfEdgesNeed)
            return noOfEdgesNeed;
        return -1;
    }

    public int makeConnected(int n, int[][] connections) {
        DisjointSet dis = new DisjointSet(n);
        int extraEdges = 0;
        for (int[] edge : connections) {
            if (dis.findParent(edge[0]) != dis.findParent(edge[1])) {
                dis.unionBySize(edge[0], edge[1]);
            } else {
                extraEdges++;
            }
        }
        int noOfComponents = 0;
        for (int i = 1; i <= n; i++) {
            if (dis.findParent(i) == i)
                noOfComponents++;
        }
        int noOfEdgesNeed = noOfComponents - 1;
        if (extraEdges >= noOfEdgesNeed)
            return noOfEdgesNeed;
        return -1;
    }
}
