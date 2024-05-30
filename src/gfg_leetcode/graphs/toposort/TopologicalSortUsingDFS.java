package gfg_leetcode.graphs.toposort;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TopologicalSortUsingDFS {
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {
        Stack<Integer> st = new Stack<>();
        boolean[] vis = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                dfs(i, vis, adj, st);
            }
        }
        List<Integer> ans = new ArrayList<>();
        while (!st.isEmpty()) {
            ans.add(st.pop());
        }
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }

    static void dfs(int v, boolean[] vis, ArrayList<ArrayList<Integer>> adj, Stack<Integer> st) {
        vis[v] = true;
        ArrayList<Integer> conn = adj.get(v);
        for (int ele : conn) {
            if (!vis[ele]) {
                dfs(ele, vis, adj, st);
            }
        }
        st.push(v);
    }
}
