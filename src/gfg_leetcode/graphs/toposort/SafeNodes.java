package gfg_leetcode.graphs.toposort;

import java.util.ArrayList;
import java.util.List;

public class SafeNodes {
    public static void main(String[] args) {
        int[][] graph = {{1, 2}, {2, 3}, {5}, {0}, {5}, {}, {}};
        System.out.println(eventualSafeNodes(graph));
    }

    public static List<Integer> eventualSafeNodes(int[][] graph) {
        int v = graph.length;
        boolean[] isSafeNodes = new boolean[v];
        boolean[] vis = new boolean[v];
        boolean[] currVis = new boolean[v];
        for (int i = 0; i < v; i++) {
            if (!vis[i]) {
                dfs(i, vis, currVis, isSafeNodes, graph);
            }
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < isSafeNodes.length; i++) {
            if (isSafeNodes[i])
                ans.add(i);
        }
        return ans;
    }

    static boolean dfs(int v, boolean[] vis, boolean[] currVis, boolean[] isSafe, int[][] graph) {
        vis[v] = true;
        currVis[v] = true;
        isSafe[v] = true;
        int[] conn = graph[v];
        for (int ele : conn) {
            if (!vis[ele]) {
                if (dfs(ele, vis, currVis, isSafe, graph)) {
                    isSafe[v] = false;
                    return true;
                }
            } else if (currVis[ele]) {
                isSafe[v] = false;
                return true;
            }
        }
        currVis[v] = false;
        return false;
    }

    List<Integer> eventualSafeNodes(int v, List<List<Integer>> adj) {
        boolean[] isSafeNodes = new boolean[v];
        boolean[] vis = new boolean[v];
        boolean[] currVis = new boolean[v];
        for (int i = 0; i < v; i++) {
            if (!vis[i]) {
                dfs2(i, vis, currVis, isSafeNodes, adj);
            }
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < isSafeNodes.length; i++) {
            if (isSafeNodes[i])
                ans.add(i);
        }
        return ans;
    }

    static boolean dfs2(int v, boolean[] vis, boolean[] currVis, boolean[] isSafe, List<List<Integer>> adj) {
        vis[v] = true;
        currVis[v] = true;
        isSafe[v] = true;
        List<Integer> conn = adj.get(v);
        for (int ele : conn) {
            if (!vis[ele]) {
                if (dfs2(ele, vis, currVis, isSafe, adj)) {
                    isSafe[v] = false;
                    return true;
                }
            } else if (currVis[ele]) {
                isSafe[v] = false;
                return true;
            }
        }
        currVis[v] = false;
        return false;
    }
}
