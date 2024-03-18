package graphs.bfs_dfs_problems;

import java.util.ArrayList;
import java.util.Arrays;

public class BipartiteGraphUsingDFS {
    public static boolean isGraphBirpatite(ArrayList<ArrayList<Integer>> edges) {
        int v = edges.size();
        int[] colorsFilled = new int[v];
        Arrays.fill(colorsFilled, -1);
        for (int i = 0; i < v; i++) {
            if (colorsFilled[i] == -1) {
                if (!dfs(edges, i, 0, colorsFilled)) return false;
            }
        }
        return true;
    }

    static boolean dfs(ArrayList<ArrayList<Integer>> edges, int curr, int currColor, int[] colorsFilled) {
        colorsFilled[curr] = currColor;
        ArrayList<Integer> conn = edges.get(curr);
        for (Integer node : conn) {
            if (node != curr) {
                if (colorsFilled[node] == -1) {
                    if (!dfs(edges, node, 1 - currColor, colorsFilled)) return false;
                } else if (colorsFilled[node] == currColor) {
                    return false;
                }
            }
        }
        return true;
    }

    static boolean dfsSearch(int[][] graph, int curr, int currColor, int[] colorsFilled) {
        colorsFilled[curr] = currColor;
        int[] conn = graph[curr];
        for (int node : conn) {
            if (colorsFilled[node] == -1) {
                if (!dfsSearch(graph, node, 1 - currColor, colorsFilled)) return false;
            } else if (colorsFilled[node] == currColor) {
                return false;
            }
        }
        return true;
    }

    public boolean isBipartite(int[][] graph) {
        int v = graph.length;
        int[] colorsFilled = new int[v];
        Arrays.fill(colorsFilled, -1);
        for (int i = 0; i < v; i++) {
            if (colorsFilled[i] == -1) {
                if (!dfsSearch(graph, i, 0, colorsFilled)) return false;
            }
        }
        return true;
    }
}
