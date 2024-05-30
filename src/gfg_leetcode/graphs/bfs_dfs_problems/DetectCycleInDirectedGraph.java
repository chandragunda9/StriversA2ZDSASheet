package gfg_leetcode.graphs.bfs_dfs_problems;

import java.util.ArrayList;

public class DetectCycleInDirectedGraph {
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] vis = new boolean[V];
        boolean[] currVis = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                if (dfs(i, vis, currVis, adj))
                    return true;
            }
        }
        return false;
    }

    static boolean dfs(int v, boolean[] vis, boolean[] currVis, ArrayList<ArrayList<Integer>> adj) {
        vis[v] = true;
        currVis[v] = true;
        ArrayList<Integer> conn = adj.get(v);
        for (int ele : conn) {
            if (!vis[ele]) {
                if (dfs(ele, vis, currVis, adj))
                    return true;
            } else if (currVis[ele]) {
                return true;
            }
        }
        currVis[v] = false;
        return false;
    }
}
