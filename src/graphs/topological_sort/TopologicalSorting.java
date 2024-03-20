package graphs.topological_sort;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TopologicalSorting {
    public static List<Integer> topologicalSort(int[][] edges, int e, int v) {
        //build adjacency list
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
        }

        Stack<Integer> st = new Stack<>();
        boolean[] vis = new boolean[v];
        for (int i = 0; i < v; i++) {
            if (!vis[i])
                dfs(adj, i, vis, st);
        }
        List<Integer> ans = new ArrayList<>();
        while (!st.isEmpty()) {
            ans.add(st.pop());
        }
        return ans;
    }

    static void dfs(List<List<Integer>> adj, int v, boolean[] vis, Stack<Integer> st) {
        vis[v] = true;
        List<Integer> conn = adj.get(v);
        for (Integer ele : conn) {
            if (!vis[ele]) {
                dfs(adj, ele, vis, st);
            }
        }
        st.push(v);
    }
}
