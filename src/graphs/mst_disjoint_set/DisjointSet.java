package graphs.mst_disjoint_set;


public class DisjointSet {
    int[] ranks;
    int[] parents;
    int[] sizes;

    public DisjointSet(int n) {
        ranks = new int[n + 1];
        parents = new int[n + 1];
        sizes = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            parents[i] = i;
            ranks[i] = 0;
            sizes[i] = 1;
        }
    }

    public int findParent(int node) {
        if (node == parents[node]) {
            return node;
        }
        return parents[node] = findParent(parents[node]);
    }

    public void unionByRank(int x, int y) {
        int rootX = findParent(x);
        int rootY = findParent(y);
        if (rootY == rootX)
            return;
        if (ranks[rootX] < ranks[rootY]) {
            parents[rootX] = rootY;
        } else if (ranks[rootY] < ranks[rootX]) {
            parents[rootY] = rootX;
        } else {
            parents[rootY] = rootX;
            ranks[rootX]++;
        }
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

    public static void main(String[] args) {
        DisjointSet dis = new DisjointSet(7);
//        dis.unionByRank(1, 2);
//        dis.unionByRank(2, 3);
//        dis.unionByRank(4, 5);
//        dis.unionByRank(6, 7);
//        dis.unionByRank(5, 6);

        dis.unionBySize(1, 2);
        dis.unionBySize(2, 3);
        dis.unionBySize(4, 5);
        dis.unionBySize(6, 7);
        dis.unionBySize(5, 6);

        //check whether 3 and 7 are belong to same root or not
        if (dis.findParent(3) == dis.findParent(7)) {
            System.out.println("Belong to same set");
        } else {
            System.out.println("Not belong to same set");
        }

//        dis.unionByRank(3, 6);
        dis.unionBySize(3, 6);

        if (dis.findParent(3) == dis.findParent(7)) {
            System.out.println("Belong to same set");
        } else {
            System.out.println("Not belong to same set");
        }
    }
}
