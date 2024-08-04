package graphs.other_algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BridgesInAGraph {
    static int time = 0;
    public static void main(String[] args) {
        int[][] connections = {{0, 1}, {1, 2}, {2, 0}, {1, 3}};
        int n = 4;
        List<List<Integer>> conn = Arrays.stream(connections).map(ar -> Arrays.stream(ar).boxed().toList()).toList();
        System.out.println(criticalConnections(n, conn));
    }

    public static List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        //build adjacency list
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (List<Integer> conn : connections) {
            adj.get(conn.get(0)).add(conn.get(1));
            adj.get(conn.get(1)).add(conn.get(0));
        }

        List<List<Integer>> ans = new ArrayList<>();
        int[] disTime = new int[n];
        int[] lowTime = new int[n];
        boolean[] vis = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                dfs(i, -1, vis, disTime, lowTime, adj, ans);
            }
        }
        return ans;
    }

    static void dfs(int u, int p, boolean[] vis, int[] disTime, int[] lowTime,
                    List<List<Integer>> adj, List<List<Integer>> ans) {
        vis[u] = true;
        disTime[u] = lowTime[u] = time;
        time++;
        List<Integer> conn = adj.get(u);
        for (int v : conn) {
            if (!vis[v]) {
                dfs(v, u, vis, disTime, lowTime, adj, ans);
                lowTime[u] = Math.min(lowTime[u], lowTime[v]);
                if (lowTime[v] > disTime[u]) {
                    ans.add(new ArrayList<>(Arrays.asList(u, v)));
                }
            } else if (v != p) {
                lowTime[u] = Math.min(lowTime[u], lowTime[v]);
            }
        }
    }
}
