package graphs.shortest_path_algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class DAGShortestPath {
    static class Node {
        int next, weight;

        public Node(int next, int weight) {
            this.next = next;
            this.weight = weight;
        }
    }

    public static int[] shortestPathInDAG(int n, int m, int[][] edges) {
        //build adjacency list
        List<List<Node>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(new Node(edge[1], edge[2]));
        }
        //finding topological sort
        boolean[] vis = new boolean[n];
        Stack<Integer> st = new Stack<>();
        for (int v = 0; v < n; v++) {
            if (!vis[v]) {
                dfs(adj, v, vis, st);
            }
        }
        //let the distances of all vertices be equal to max value
        int[] dis = new int[n];
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[0] = 0;
        while (!st.isEmpty() && st.peek() != 0) {
            st.pop();
        }
        while (!st.isEmpty()) {
            Integer top = st.pop();
            List<Node> conn = adj.get(top);
            for (Node e : conn) {
                int cv = e.next, w = e.weight;
                if (dis[top] + w < dis[cv]) {
                    dis[cv] = dis[top] + w;
                }
            }
        }
        for (int i = 0; i < dis.length; i++) {
            if (dis[i] == Integer.MAX_VALUE)
                dis[i] = -1;
        }
        return dis;
    }

    static void dfs(List<List<Node>> adj, int v, boolean[] vis, Stack<Integer> st) {
        vis[v] = true;
        List<Node> conn = adj.get(v);
        for (Node ele : conn) {
            if (!vis[ele.next])
                dfs(adj, ele.next, vis, st);
        }
        st.push(v);
    }
}
