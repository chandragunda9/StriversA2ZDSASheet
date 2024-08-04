package graphs.other_algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class FindWhetherEdgeIsBridgeOrNot {
    static int time = 0;

    public static void main(String[] args) {
//        int n = 4;
//        int[][] arr = {{1}, {0, 2}, {1, 3}, {2}};
//        int c = 1, d = 2;
        int n = 5;
        int[][] arr = {{1, 2, 3}, {0, 2}, {0, 1}, {0, 4}, {3}};
        int c = 0, d = 2;
        ArrayList<ArrayList<Integer>> adj = Arrays.stream(arr).map(ar -> Arrays.stream(ar).boxed().collect(Collectors.toCollection(ArrayList::new)))
                .collect(Collectors.toCollection(ArrayList::new));
        System.out.println(isBridge(n, adj, c, d));
    }

    static int isBridge(int V, ArrayList<ArrayList<Integer>> adj, int c, int d) {
        int[] disTime = new int[V];
        int[] lowTime = new int[V];
        boolean[] vis = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                if (dfs(i, -1, vis, disTime, lowTime, adj, c, d))
                    return 1;
            }
        }
        return 0;
    }

    static boolean dfs(int u, int p, boolean[] vis, int[] disTime, int[] lowTime,
                       ArrayList<ArrayList<Integer>> adj, int c, int d) {
        vis[u] = true;
        disTime[u] = lowTime[u] = time;
        time++;
        ArrayList<Integer> conn = adj.get(u);
        for (int v : conn) {
            if (!vis[v]) {
                if (dfs(v, u, vis, disTime, lowTime, adj, c, d))
                    return true;
                lowTime[u] = Math.min(lowTime[u], lowTime[v]);
                if (lowTime[v] > disTime[u]) {
                    if ((c == u || c == v) && (d == u || d == v))
                        return true;
                }
            } else if (v != p) {
                lowTime[u] = Math.min(lowTime[u], lowTime[v]);
            }
        }
        return false;
    }
}
