package graphs.learning;

import java.util.ArrayList;
import java.util.List;

public class DFS {
    public static ArrayList<ArrayList<Integer>> depthFirstSearch(int v, int e,
                                                                 ArrayList<ArrayList<Integer>> edges) {

        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        boolean[] vis = new boolean[v];
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < e; i++) {
            ArrayList<Integer> edge = edges.get(i);
            adj.get(edge.get(0)).add(edge.get(1));
            adj.get(edge.get(1)).add(edge.get(0));
        }
        for (int i = 0; i < v; i++) {
            if (!vis[i]) {
                ArrayList<Integer> al = new ArrayList<>();
                dfs(adj, i, vis, al);
                ans.add(al);
            }
        }
        return ans;
    }

    static void dfs(List<List<Integer>> adj, int v, boolean[] vis,
                    ArrayList<Integer> al) {
        vis[v] = true;
        al.add(v);
        List<Integer> conn = adj.get(v);
        for (Integer ele : conn) {
            if (!vis[ele]) {
                dfs(adj, ele, vis, al);
            }
        }
    }
}
