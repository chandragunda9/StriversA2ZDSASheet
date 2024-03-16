package graphs.learning;

public class NumberOfProvinces {
    public static int findNumOfProvinces(int[][] roads, int n) {
        boolean[] vis = new boolean[n];
        int noOfProvinces = 0;
        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                dfs(i, roads, vis);
                noOfProvinces++;
            }
        }
        return noOfProvinces;
    }

    static void dfs(int v, int[][] roads, boolean[] vis) {
        vis[v] = true;
        int[] conn = roads[v];
        for (int i = 0; i < conn.length; i++) {
            if (v != i && conn[i] == 1 && !vis[i]) {
                dfs(i, roads, vis);
            }
        }
    }
}
