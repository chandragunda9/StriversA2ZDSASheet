package practice.graphs.other_algorithms.learning;

public class NumberOfProvinces {
    public static int findNumOfProvinces(int[][] roads, int n) {
        int count = 0;
        boolean[] vis = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                dfs(roads, i, vis);
                count++;
            }
        }
        return count;
    }

    static void dfs(int[][] roads, int v, boolean[] vis) {
        vis[v] = true;
        int[] conn = roads[v];
        for (int i = 0; i < conn.length; i++) {
            if (i != v && conn[i] == 1 && !vis[i]) {
                dfs(roads, i, vis);
            }
        }
    }
}
