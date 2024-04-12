package graphs.mst_disjoint_set;

import java.util.*;

public class MSTUsingPrims {
    static class Node {
        int val, weight;

        public Node(int val, int weight) {
            this.val = val;
            this.weight = weight;
        }
    }

    static class Tuple {
        int w, currNode, parent;

        public Tuple(int w, int currNode, int parent) {
            this.w = w;
            this.currNode = currNode;
            this.parent = parent;
        }
    }

    public static int minimumSpanningTree(ArrayList<ArrayList<Integer>> edges, int n) {
        //using prims algorithm
        //build adjacency list
        int mstWeight = 0;
        List<List<Node>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (ArrayList<Integer> edge : edges) {
            adj.get(edge.get(0)).add(new Node(edge.get(1), edge.get(2)));
            adj.get(edge.get(1)).add(new Node(edge.get(0), edge.get(2)));
        }
        boolean[] vis = new boolean[n];
        Queue<Tuple> q = new PriorityQueue<>(Comparator.comparingInt(a -> a.w));
        q.add(new Tuple(0, 0, -1));
        while (!q.isEmpty()) {
            Tuple rem = q.poll();
            if (!vis[rem.currNode]) {
                vis[rem.currNode] = true;
                mstWeight += rem.w;
                List<Node> conn = adj.get(rem.currNode);
                for (Node ele : conn) {
                    if (!vis[ele.val]) {
                        q.add(new Tuple(ele.weight, ele.val, rem.currNode));
                    }
                }
            }
        }
        return mstWeight;
    }
}
