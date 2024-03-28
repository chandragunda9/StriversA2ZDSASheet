package graphs.shortest_path_algorithms;

import java.util.*;

public class DijkstrasAlgorithm {
    static class Node {
        int node, cost;

        public Node(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }
    }

    public static List<Integer> dijkstra(int[][] edge, int vertices, int edges, int source) {
        //build adjacency list
        List<List<Node>> adj = new ArrayList<>();
        for (int i = 0; i < vertices; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] ed : edge) {
            adj.get(ed[0]).add(new Node(ed[1], ed[2]));
            adj.get(ed[1]).add(new Node(ed[0], ed[2]));
        }
        //initially all distances keeping as 0
        Integer[] dis = new Integer[vertices];
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[source] = 0;

        Queue<Node> q = new PriorityQueue<>(Comparator.comparingInt(a -> a.cost));
        q.add(new Node(source, 0));
        while (!q.isEmpty()) {
            Node rem = q.poll();
            int v = rem.node;
            int di = rem.cost;
            List<Node> conn = adj.get(v);
            for (Node ele : conn) {
                if (di + ele.cost < dis[ele.node]) {
                    dis[ele.node] = di + ele.cost;
                    q.add(new Node(ele.node, dis[ele.node]));
                }
            }
        }
        return new ArrayList<>(Arrays.asList(dis));
    }
}
