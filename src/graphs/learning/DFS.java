package graphs.learning;

import java.util.ArrayList;

public class DFS {
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> ans = new ArrayList<>();
        boolean[] vis = new boolean[V];
        dfs(0, vis, adj, ans);
        return ans;
    }

    static void dfs(int v, boolean[] vis, ArrayList<ArrayList<Integer>> adj,
                    ArrayList<Integer> ans) {
        vis[v] = true;
        ans.add(v);
        ArrayList<Integer> conn = adj.get(v);
        for (int ele : conn) {
            if (!vis[ele])
                dfs(ele, vis, adj, ans);
        }
    }
}
