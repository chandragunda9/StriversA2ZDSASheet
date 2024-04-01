package graphs.shortest_path_algorithms;

import java.util.*;

public class NoOfWaysToReachDestination {
    static class Node {
        int v, cost;

        public Node(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }
    }

    public static int numberOfWays(int n, int m, int[][] edges) {
        List<List<Node>> adj = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(new Node(edge[1], edge[2]));
            adj.get(edge[1]).add(new Node(edge[0], edge[2]));
        }
        int src = 0, mod = (int) (1e9 + 7);
        int[] dist = new int[n];
        long[] ways = new long[n];

        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(ways, 0);

        dist[src] = 0;
        ways[src] = 1;
        Queue<Node> q = new PriorityQueue<>(Comparator.comparing(a -> a.cost));
        q.add(new Node(0, 0));

        while (!q.isEmpty()) {
            Node rem = q.poll();
            List<Node> conn = adj.get(rem.v);
            for (Node ele : conn) {
                if (rem.cost + ele.cost < dist[ele.v]) {
                    dist[ele.v] = rem.cost + ele.cost;
                    q.add(new Node(ele.v, rem.cost + ele.cost));
                    ways[ele.v] = ways[rem.v];
                } else if (rem.cost + ele.cost == dist[ele.v]) {
                    ways[ele.v] = (ways[ele.v] + ways[rem.v]) % mod;
                }
            }
        }
        return (int) ways[n - 1];
    }

    public static void main(String[] args) {
        int[][] edges = {{0, 1, 3}, {0, 2, 7}, {1, 2, 4}};
        int n = 3, m = 3;
        System.out.println(numberOfWays(n, m, edges));
    }

    public int countPaths(int n, int[][] roads) {
        return numberOfWays(n, roads.length, roads);
    }
}
