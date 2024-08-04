package graphs.bfs_dfs_problems;

import java.util.ArrayList;

public class DetectCycleInDirectedGraphUsingDFS {
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] vis = new boolean[V];
        boolean[] currVis = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                if (dfs(i, adj, vis, currVis))
                    return true;
            }
        }
        return false;
    }

    static boolean dfs(int v, ArrayList<ArrayList<Integer>> adj, boolean[] vis, boolean[] currVis) {
        vis[v] = true;
        currVis[v] = true;
        ArrayList<Integer> conn = adj.get(v);
        for (int ele : conn) {
            if (!vis[ele]) {
                if (dfs(ele, adj, vis, currVis))
                    return true;
            } else if (currVis[ele]) {
                return true;
            }
        }
        currVis[v] = false;
        return false;
    }
}
