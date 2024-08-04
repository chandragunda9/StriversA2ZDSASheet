package graphs.other_algorithms;

import java.util.ArrayList;
import java.util.List;

public class ArticulationPoint {
    static int time = 0;

    public ArrayList<Integer> articulationPoints(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> ans = new ArrayList<>();
        int[] disTime = new int[V];
        int[] lowTime = new int[V];
        boolean[] vis = new boolean[V];
        boolean[] isArtPoint = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                dfs(i, -1, vis, disTime, lowTime, adj, isArtPoint);
            }
        }
        for (int i = 0; i < isArtPoint.length; i++) {
            if (isArtPoint[i])
                ans.add(i);
        }
        return ans.isEmpty() ? new ArrayList<>(List.of(-1)) : ans;
    }

    static void dfs(int u, int parent, boolean[] vis, int[] disTime, int[] lowTime,
                    ArrayList<ArrayList<Integer>> adj, boolean[] isArtPoint) {
        vis[u] = true;
        disTime[u] = lowTime[u] = time;
        time++;
        List<Integer> conn = adj.get(u);
        int child = 0;
        for (int v : conn) {
            if (!vis[v]) {
                dfs(v, u, vis, disTime, lowTime, adj, isArtPoint);
                lowTime[u] = Math.min(lowTime[u], lowTime[v]);
                if (lowTime[v] >= disTime[u] && parent != -1) {
                    isArtPoint[u] = true;
                }
                child++;
            } else if (v != parent) {
                lowTime[u] = Math.min(lowTime[u], disTime[v]);
            }
        }
        if (child > 1 && parent == -1) {
            isArtPoint[u] = true;
        }
    }
}
