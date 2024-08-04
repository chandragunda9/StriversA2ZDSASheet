package graphs.bfs_dfs_problems;

import java.util.ArrayList;
import java.util.Arrays;

public class BipartiteGraph {
    public boolean isBipartite(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] colorsFilled = new int[V];
        Arrays.fill(colorsFilled, -1);
        for (int i = 0; i < V; i++) {
            if (colorsFilled[i] == -1) {
                if (!dfs(i, 0, colorsFilled, adj))
                    return false;
            }
        }
        return true;
    }

    static boolean dfs(int v, int color, int[] colorsFilled, ArrayList<ArrayList<Integer>> adj) {
        colorsFilled[v] = color;
        ArrayList<Integer> conn = adj.get(v);
        for (int ele : conn) {
            if (colorsFilled[ele] == -1) {
                if (!dfs(ele, 1 - color, colorsFilled, adj))
                    return false;
            } else if (colorsFilled[ele] == color) {
                return false;
            }
        }
        return true;
    }
}
