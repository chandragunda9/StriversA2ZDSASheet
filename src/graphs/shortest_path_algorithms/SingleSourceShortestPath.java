package graphs.shortest_path_algorithms;

import java.util.*;

public class SingleSourceShortestPath {
    static class Node {
        int vertex, weight;

        public Node(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "vertex=" + vertex +
                    ", weight=" + weight +
                    '}';
        }
    }

    public static void main(String[] args) {
        int[][] edges = {{0, 1}, {0, 3}, {2, 3}};
        int n = 4, src = 0;
        System.out.println(Arrays.toString(shortestPath(n, edges, src)));
    }

    public static int[] shortestPath(int n, int[][] edges, int src) {
        //build adjacency list
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        //finding min distances using queue
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(src, 0));
        while (!q.isEmpty()) {
            Node rem = q.poll();
            List<Integer> conn = adj.get(rem.vertex);
            for (Integer ele : conn) {
                if (dist[rem.vertex] + 1 < dist[ele]) {
                    dist[ele] = dist[rem.vertex] + 1;
                    q.add(new Node(ele, dist[ele]));
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
