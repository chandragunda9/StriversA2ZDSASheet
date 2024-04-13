package graphs.mst_disjoint_set;

import java.util.*;

public class NetworkDelayTime {
    static class Node {
        int node, time;

        public Node(int node, int time) {
            this.node = node;
            this.time = time;
        }
    }

    public static int networkDelayTime(int[][] edges, int n, int k) {
        //By using Dijkstras Algorithm
        // k is the source node
        //build adjacency list
        List<List<Node>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(new Node(edge[1], edge[2]));
        }
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;
        Queue<Node> q = new PriorityQueue<>(Comparator.comparingInt(a -> a.time));
        q.add(new Node(k, 0));
        while (!q.isEmpty()) {
            Node rem = q.poll();
            List<Node> conn = adj.get(rem.node);
            for (Node ele : conn) {
                if (rem.time + ele.time < dist[ele.node]) {
                    dist[ele.node] = rem.time + ele.time;
                    q.add(new Node(ele.node, dist[ele.node]));
                }
            }
        }
        int ans = 0;
        for (int i = 1; i < dist.length; i++) {
            if (dist[i] == Integer.MAX_VALUE)
                return -1;
            ans = Math.max(ans, dist[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        int n = 4, e = 3;
        int source = 1;
        int[][] edges = {{1, 2, 2}, {1, 3, 1}, {3, 4, 2}};
        System.out.println(networkDelayTime(edges, n, source));
    }
}
