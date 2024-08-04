package graphs.shortest_path;

import java.util.*;

public class ShortestPathInUndirectedGraph {
    public static void main(String[] args) {
        int n = 9, m = 10;
        int src = 0;
        int[][] edges = {{0, 1}, {0, 3}, {3, 4}, {4, 5}, {5, 6}, {1, 2}, {2, 6}, {6, 7}, {7, 8}, {6, 8}};
        System.out.println(Arrays.toString(shortestPath(edges, n, m, src)));
    }

    public static int[] shortestPath(int[][] edges, int n, int m, int src) {
        Queue<Integer> q = new LinkedList<>();
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        q.add(src);
        dist[src] = 0;
        while (!q.isEmpty()) {
            Integer rem = q.poll();
            List<Integer> conn = adj.get(rem);
            for (int ele : conn) {
                if (dist[rem] + 1 < dist[ele]) {
                    dist[ele] = dist[rem] + 1;
                    q.add(ele);
                }
            }
        }
        for (int i = 0; i < dist.length; i++) {
            if (dist[i] == Integer.MAX_VALUE)
                dist[i] = -1;
        }
        return dist;
    }
}
