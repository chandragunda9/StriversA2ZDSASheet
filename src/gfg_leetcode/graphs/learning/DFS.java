package gfg_leetcode.graphs.learning;

import java.util.ArrayList;

public class DFS {
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] vis = new boolean[V];
        ArrayList<Integer> ans = new ArrayList<>();
        dfs(0, adj, vis, ans);
        return ans;
    }

    static void dfs(int v, ArrayList<ArrayList<Integer>> adj, boolean[] vis, ArrayList<Integer> ans) {
        vis[v] = true;
        ans.add(v);
        ArrayList<Integer> conn = adj.get(v);
        for (int ele : conn) {
            if (!vis[ele]) {
                dfs(ele, adj, vis, ans);
            }
        }
    }
}
