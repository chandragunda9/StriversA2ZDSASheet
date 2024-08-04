package graphs.mst_disjointset;

import java.util.*;

public class PrimsAlgorithm {
    static class Node {
        int weight;
        int node;
        int parent;

        public Node(int weight, int node, int parent) {
            this.weight = weight;
            this.node = node;
            this.parent = parent;
        }

        public Node(int weight, int node) {
            this.weight = weight;
            this.node = node;
        }
    }

    static int minimumSpanningTree(int V, int E, List<List<int[]>> adj) {
        Queue<Node> q = new PriorityQueue<>(Comparator.comparingInt(a -> a.weight));
        boolean[] vis = new boolean[V];
        int sum = 0;
        List<List<Integer>> mst = new ArrayList<>();
        q.add(new Node(0, 0, -1));
        while (!q.isEmpty()) {
            Node rem = q.poll();
            if (vis[rem.node])
                continue;
            vis[rem.node] = true;
            if (rem.parent != -1) {
                sum += rem.weight;
                mst.add(new ArrayList<>(Arrays.asList(rem.node, rem.parent)));
            }
            List<int[]> conn = adj.get(rem.node);
            for (int[] ele : conn) {
                if (!vis[ele[0]]) {
                    q.add(new Node(ele[1], ele[0], rem.node));
                }
            }
        }
        System.out.println(mst);
        return sum;
    }

    static int spanningTree(int V, int E, List<List<int[]>> adj) {
        Queue<Node> q = new PriorityQueue<>(Comparator.comparingInt(a -> a.weight));
        boolean[] vis = new boolean[V];
        int sum = 0;
        q.add(new Node(0, 0));
        while (!q.isEmpty()) {
            Node rem = q.poll();
            if (vis[rem.node])
                continue;
            vis[rem.node] = true;
            sum += rem.weight;
            List<int[]> conn = adj.get(rem.node);
            for (int[] ele : conn) {
                if (!vis[ele[0]]) {
                    q.add(new Node(ele[1], ele[0]));
                }
            }
        }
        return sum;
    }
}
