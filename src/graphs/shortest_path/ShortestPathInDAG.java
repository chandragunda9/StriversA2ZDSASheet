package graphs.shortest_path;

import java.util.*;

public class ShortestPathInDAG {
    static class Node {
        int node;
        int weight;

        public Node(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }

    public static void main(String[] args) {
//        int[][] edges = {{0, 1, 2}, {0, 2, 1}};
//        int[][] edges = {{0, 1, 2},
//                {0, 4, 1},
//                {4, 5, 4},
//                {4, 2, 2},
//                {1, 2, 3},
//                {2, 3, 6},
//                {5, 3, 1}};
//        int N = 6, M = 7;

        int[][] edges = {{0, 2, 6},
                {0, 3, 7},
                {0, 4, 9},
                {0, 6, 8},
                {0, 7, 6},
                {1, 2, 6},
                {1, 3, 7},
                {1, 5, 10},
                {1, 6, 1},
                {1, 7, 4},
                {2, 3, 3},
                {2, 6, 10},
                {2, 8, 8},
                {2, 9, 10},
                {3, 5, 3},
                {3, 6, 10},
                {3, 7, 5},
                {5, 6, 9},
                {5, 7, 7},
                {6, 7, 7},
                {6, 8, 8},
                {6, 9, 8},
                {7, 9, 1},
                {8, 9, 6}};
        int N = 10, M = 24;
        System.out.println(Arrays.toString(shortestPath(N, M, edges)));
    }

    public static int[] method1(int N, int M, int[][] edges) {
        Queue<Node> q = new LinkedList<>();
        int[] dist = new int[N];
        Arrays.fill(dist, Integer.MAX_VALUE);
        List<List<Node>> adj = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(new Node(edge[1], edge[2]));
        }

        q.add(new Node(0, 0));
        dist[0] = 0;
        while (!q.isEmpty()) {
            Node rem = q.poll();
            List<Node> conn = adj.get(rem.node);
            for (Node ele : conn) {
                if (dist[rem.node] + ele.weight < dist[ele.node]) {
                    dist[ele.node] = dist[rem.node] + ele.weight;
                    q.add(new Node(ele.node, dist[ele.node]));
                }
            }
        }
        for (int i = 0; i < dist.length; i++) {
            if (dist[i] == Integer.MAX_VALUE)
                dist[i] = -1;
        }
        return dist;
    }

    public static int[] shortestPath(int N, int M, int[][] edges) {
        //finding topological sort
        List<List<Node>> adj = new ArrayList<>();
        boolean[] vis = new boolean[N];
        Stack<Integer> st = new Stack<>();
        int[] dist = new int[N];
        Arrays.fill(dist, Integer.MAX_VALUE);

        for (int i = 0; i < N; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(new Node(edge[1], edge[2]));
        }
        for (int i = 0; i < N; i++) {
            if (!vis[i]) {
                dfs(i, vis, adj, st);
            }
        }
        dist[0] = 0;
        while (!st.isEmpty() && !st.peek().equals(0)) {
            st.pop();
        }
        while (!st.isEmpty()) {
            Integer rem = st.pop();
            List<Node> conn = adj.get(rem);
            for (Node ele : conn) {
                if (dist[rem] + ele.weight < dist[ele.node]) {
                    dist[ele.node] = dist[rem] + ele.weight;
                }
            }
        }
        for (int i = 0; i < dist.length; i++) {
            if (dist[i] == Integer.MAX_VALUE)
                dist[i] = -1;
        }
        return dist;
    }

    static void dfs(int v, boolean[] vis, List<List<Node>> adj, Stack<Integer> st) {
        vis[v] = true;
        List<Node> conn = adj.get(v);
        for (Node ele : conn) {
            if (!vis[ele.node]) {
                dfs(ele.node, vis, adj, st);
            }
        }
        st.push(v);
    }
}
