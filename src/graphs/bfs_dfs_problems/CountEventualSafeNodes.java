package graphs.bfs_dfs_problems;

import java.util.ArrayList;
import java.util.List;

public class CountEventualSafeNodes {
    public static void main(String[] args) {
        int[][] graph = {{1, 2}, {2, 3}, {5}, {0}, {5}, {}, {}};
        System.out.println(eventualSafeNodes(graph));
        int[][] edges = {{0, 1}, {1, 0}, {0, 2}};
        int n = 5, e = 3;
        System.out.println(safeNodes(edges, n, e));
    }

    public static List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        boolean[] vis = new boolean[n];
        boolean[] currPathVis = new boolean[n];
        boolean[] isSafe = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                dfs(graph, i, vis, currPathVis, isSafe);
            }
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (isSafe[i])
                ans.add(i);
        }
        return ans;
    }

    static boolean dfs(int[][] graph, int v, boolean[] vis, boolean[] currPathVis, boolean[] isSafeNodes) {
        vis[v] = true;
        currPathVis[v] = true;
        int[] conn = graph[v];
        isSafeNodes[v] = true;
        for (int ele : conn) {
            if (!vis[ele]) {
                if (dfs(graph, ele, vis, currPathVis, isSafeNodes)) {
                    isSafeNodes[v] = false;
                    return true;
                }
            } else if (currPathVis[ele]) {
                isSafeNodes[v] = false;
                return true;
            }
        }
        currPathVis[v] = false;
        return false;
    }

    public static ArrayList<Integer> safeNodes(int edges[][], int n, int e) {
        //build adjacency matrix
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            if (edge[0] != edge[1]) {
                adj.get(edge[0]).add(edge[1]);
            }
        }
        int[][] graph = adj.stream().map(li -> li.stream().mapToInt(Integer::intValue)
                .toArray()).toArray(int[][]::new);
        List<Integer> ans = eventualSafeNodes(graph);
        return new ArrayList<>(ans);
    }
}
