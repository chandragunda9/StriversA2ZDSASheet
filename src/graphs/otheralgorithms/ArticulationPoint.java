package graphs.otheralgorithms;

import java.util.*;

public class ArticulationPoint {
    static int timer = 1;

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int noOfTestCase = s.nextInt();
        while (noOfTestCase-- > 0) {
            List<List<Integer>> edges = new ArrayList<>();
            int v = s.nextInt(), e = s.nextInt();
            for (int i = 1; i <= e; i++) {
                List<Integer> edge = Arrays.asList(s.nextInt(), s.nextInt());
                edges.add(new ArrayList<>(edge));
            }

            //build adjacency graph
            List<List<Integer>> adj = new ArrayList<>();
            for (int i = 0; i <= v; i++) {
                adj.add(new ArrayList<>());
            }
            for (List<Integer> edge : edges) {
                adj.get(edge.get(0)).add(edge.get(1));
                adj.get(edge.get(1)).add(edge.get(0));
            }
            boolean[] vis = new boolean[v + 1], isArticulationPoint = new boolean[v + 1];
            int[] lowTime = new int[v + 1], disTime = new int[v + 1];
            for (int i = 1; i <= v; i++) {
                if (!vis[i]) {
                    dfs(i, -1, lowTime, disTime, vis, isArticulationPoint, adj);
                }
            }
            for (int j = 1; j <= v; j++) {
                if (isArticulationPoint[j])
                    System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    static void dfs(int u, int parent, int[] lowTime, int[] disTime, boolean[] vis, boolean[] isArticulationPoint,
                    List<List<Integer>> adj) {
        vis[u] = true;
        lowTime[u] = disTime[u] = timer;
        timer++;
        int child = 0;
        List<Integer> conn = adj.get(u);
        for (Integer v : conn) {
            if (!vis[v]) {
                dfs(v, u, lowTime, disTime, vis, isArticulationPoint, adj);
                lowTime[u] = Math.min(lowTime[u], lowTime[v]);
                if (lowTime[v] >= disTime[u] && parent != -1) {
                    isArticulationPoint[u] = true;
                }
                child++;
            } else {
                lowTime[u] = Math.min(lowTime[u], disTime[v]);
            }
        }
        if (child > 1 && parent == -1) {
            isArticulationPoint[u] = true;
        }
    }
}
