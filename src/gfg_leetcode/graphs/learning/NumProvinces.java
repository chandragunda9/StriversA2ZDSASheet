package gfg_leetcode.graphs.learning;

import java.util.ArrayList;

public class NumProvinces {
    static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
        //vertices numbered from 1 to V
        boolean[] vis = new boolean[V + 1];
        int count = 0;
        for (int i = 1; i <= V; i++) {
            if (!vis[i]) {
                dfs(i, adj, vis);
                count++;
            }
        }
        return count;
    }

    static void dfs(int v, ArrayList<ArrayList<Integer>> adj, boolean[] vis) {
        vis[v] = true;
        ArrayList<Integer> conn = adj.get(v);
        for (int i = 0; i < conn.size(); i++) {
            if (conn.get(i) == 1 && !vis[i]) {
                dfs(i, adj, vis);
            }
        }
    }
}
