package graphs.bfs_dfs_problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class NumProvinces {
    public static void main(String[] args) {
//        int[][] arr = {{1, 0, 1}, {0, 1, 0}, {1, 0, 1}};
//        int v = 3;
        int[][] arr = {{1, 1}, {1, 1}};
        int v = 2;
        ArrayList<ArrayList<Integer>> al = Arrays.stream(arr).map(a ->
                Arrays.stream(a).boxed().collect(Collectors.toCollection(ArrayList::new))).collect(Collectors.toCollection(ArrayList::new));
        System.out.println(numProvinces(al, v));
    }

    static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
        int count = 0;
        boolean[] vis = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                dfs(i, vis, adj);
                count++;
            }
        }
        return count;
    }

    static void dfs(int v, boolean[] vis, ArrayList<ArrayList<Integer>> adj) {
        vis[v] = true;
        ArrayList<Integer> conn = adj.get(v);
        for (int i = 0; i < conn.size(); i++) {
            if (conn.get(i).equals(1) && i != v && !vis[i]) {
                dfs(i, vis, adj);
            }
        }
    }
}
