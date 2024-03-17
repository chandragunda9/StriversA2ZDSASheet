package graphs.bfs_dfs_problems;

import java.util.List;

public class DetectCycleInUndirectedGraphUsingDFS {
    static class Graph {
        boolean detectCycle(int V, List<List<Integer>> adj) {
            boolean[] vis = new boolean[V];
            for (int i = 0; i < V; i++) {
                if (!vis[i]) {
                    if (dfs(adj, i, -1, vis))
                        return true;
                }
            }
            return false;
        }

        static boolean dfs(List<List<Integer>> adj, int v, int p, boolean[] vis) {
            vis[v] = true;
            List<Integer> conn = adj.get(v);
            for (Integer ele : conn) {
                if (!vis[ele]) {
                    if (dfs(adj, ele, v, vis))
                        return true;
                } else if (ele != p)
                    return true;
            }
            return false;
        }
    }
}
