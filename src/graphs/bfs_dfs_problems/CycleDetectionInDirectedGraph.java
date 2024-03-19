package graphs.bfs_dfs_problems;

import java.util.ArrayList;
import java.util.List;

public class CycleDetectionInDirectedGraph {
    public static void main(String[] args) {
        int v = 4, e = 4;
        int[][] edges = {{0, 1}, {1, 2}, {2, 3}, {3, 0}};
//        int v = 3, e = 3;
//        int[][] edges = {{1, 0}, {1, 2}, {0, 2}};
        System.out.println(isCyclic(edges, v, e));
    }

    public static Boolean isCyclic(int[][] edges, int v, int e) {
        //build adjacency list
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < e; i++) {
            int[] edge = edges[i];
            adj.get(edge[0]).add(edge[1]);
        }
        //by making use of two visited arrays
        boolean[] vis = new boolean[v];
        boolean[] dfsVis = new boolean[v];
        for (int i = 0; i < v; i++) {
            if (!vis[i]) {
                if (hasCycle(i, adj, vis, dfsVis))
                    return true;
            }
        }
        return false;
    }

    static boolean hasCycle(int v, List<List<Integer>> adj, boolean[] vis, boolean[] currPathVis) {
        vis[v] = true;
        currPathVis[v] = true;
        List<Integer> conn = adj.get(v);
        for (Integer ele : conn) {
            if (!vis[ele]) {
                if (hasCycle(ele, adj, vis, currPathVis))
                    return true;
            } else if (currPathVis[ele]) {
                return true;
            }
        }
        currPathVis[v] = false;
        return false;
    }
}
