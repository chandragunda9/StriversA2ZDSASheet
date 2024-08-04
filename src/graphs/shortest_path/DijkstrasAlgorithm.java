package graphs.shortest_path;

import java.util.*;

public class DijkstrasAlgorithm {
    static class Node {
        int node;
        int cost;

        public Node(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }
    }

    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S) {
        Queue<Node> q = new PriorityQueue<>(Comparator.comparingInt(a -> a.cost));
        int[] dis = new int[V];
        Arrays.fill(dis, Integer.MAX_VALUE);

        q.add(new Node(S, 0));
        dis[S] = 0;
        while (!q.isEmpty()) {
            Node rem = q.poll();
            ArrayList<ArrayList<Integer>> conn = adj.get(rem.node);
            for (ArrayList<Integer> ele : conn) {
//                if (rem.cost + ele.get(1) < dis[ele.get(0)])
                if (dis[rem.node] + ele.get(1) < dis[ele.get(0)]) {
                    dis[ele.get(0)] = dis[rem.node] + ele.get(1);
                    q.add(new Node(ele.get(0), dis[ele.get(0)]));
                }
            }
        }
        return dis;
    }
}
