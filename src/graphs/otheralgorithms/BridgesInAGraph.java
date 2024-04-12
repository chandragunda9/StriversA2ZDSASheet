package graphs.otheralgorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BridgesInAGraph {
    static int timer = 1;
    static void dfs(int u, int parent, List<List<Integer>> adj,
                    int[] disTime, int[] lowTime, boolean[] vis, List<List<Integer>> bridges) {
        vis[u] = true;
        disTime[u] = lowTime[u] = timer;
        timer++;
        List<Integer> conn = adj.get(u);
        for (Integer v : conn) {
            if (v == parent)
                continue;
            if (vis[v]) {
                lowTime[u] = Math.min(lowTime[u], lowTime[v]);
            } else {
                dfs(v, u, adj, disTime, lowTime, vis, bridges);
                lowTime[u] = Math.min(lowTime[u], lowTime[v]);
                if (lowTime[v] > disTime[u]) {
                    bridges.add(new ArrayList<>(Arrays.asList(v, u)));
                }
            }
        }
    }

    public static List<List<Integer>> findBridges(int[][] edges, int v, int e) {
        //build adjacency list
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        List<List<Integer>> bridges = new ArrayList<>();
        boolean[] vis = new boolean[v];
        int[] disTime = new int[v];
        int[] lowTime = new int[v];
        dfs(0, -1, adj, disTime, lowTime, vis, bridges);
        return bridges;
    }

    public static void main(String[] args) {
//        int n = 5, e = 4;
//        int[][] edges = {{0, 1}, {3, 1}, {1, 2}, {3, 4}};
        int n = 6, e = 7;
        int[][] edges = {{1, 2}, {1, 0}, {0, 2}, {0, 4}, {5, 4}, {5, 3}, {3, 4}};
        System.out.print(findBridges(edges, n, e));
    }
}
