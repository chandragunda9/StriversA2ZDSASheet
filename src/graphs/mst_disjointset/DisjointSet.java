package graphs.mst_disjointset;

import java.util.ArrayList;
import java.util.List;

class DisjointSet {
    List<Integer> parent = new ArrayList<>();
    List<Integer> rank = new ArrayList<>();
    List<Integer> size = new ArrayList<>();

    public DisjointSet(int n) {
        for (int i = 0; i <= n; i++) {
            parent.add(i);
            rank.add(0);
            size.add(1);
        }
    }

    public int findParent(int node) {
        if (node == parent.get(node)) return node;
        int ulp = findParent(parent.get(node));
        parent.set(node, ulp);
        return parent.get(node);
    }

    public void unionBySize(int u, int v) {
        int rootU = findParent(u);
        int rootV = findParent(v);
        if (rootU == rootV)
            return;
        if (size.get(rootU) < size.get(rootV)) {
            parent.set(rootU, rootV);
            size.set(rootV, size.get(rootV) + size.get(rootU));
        } else {
            parent.set(rootV, rootU);
            size.set(rootU, size.get(rootU) + size.get(rootV));
        }
    }

    int find(int parent[], int X) {
        if (X == parent[X])
            return X;
        return parent[X] = find(parent, parent[X]);
    }

    void unionSet(int parent[], int X, int Z) {
        int rootX = find(parent, X);
        int rootZ = find(parent, Z);
        if (rootX == rootZ)
            return;
        parent[rootX] = rootZ;
    }

    public void unionByRank(int u, int v) {
        int rootU = findParent(u);
        int rootV = findParent(v);
        if (rootU == rootV) return;
        if (rank.get(rootU) < rank.get(rootV)) {
            parent.set(rootU, rootV);
        } else if (rank.get(rootV) < rank.get(rootU)) {
            parent.set(rootV, rootU);
        } else {
            parent.set(rootV, rootU);
            int rankU = rank.get(rootU);
            rank.set(rootU, rankU + 1);
        }
    }

    public static void main(String[] args) {
        int n = 7;
        DisjointSet dis = new DisjointSet(n);
        dis.unionBySize(1, 2);
        dis.unionBySize(2, 3);
        dis.unionBySize(4, 5);
        dis.unionBySize(6, 7);
        dis.unionBySize(5, 6);
        if (dis.findParent(3) == dis.findParent(7)) {
            System.out.println("Same");
        } else {
            System.out.println("Not Same");
        }
        dis.unionBySize(1, 7);
        if (dis.findParent(3) == dis.findParent(7)) {
            System.out.println("Same");
        } else {
            System.out.println("Not Same");
        }
    }
}
