package graphs.shortest_path;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class BellmanFordAlgorithm {
    public static void main(String[] args) {
        int[][] edges = {{0, 1, 5}, {1, 0, 3}, {1, 2, -1}, {2, 0, 1}};
        int n = 3, s = 2;
        ArrayList<ArrayList<Integer>> al = Arrays.stream(edges).map(ar ->
                        Arrays.stream(ar).boxed().collect(Collectors.toCollection(ArrayList::new)))
                .collect(Collectors.toCollection(ArrayList::new));
        System.out.println(Arrays.toString(bellman_ford(n, al, s)));
    }

    static int[] bellman_ford(int V, ArrayList<ArrayList<Integer>> edges, int S) {
        int[] dist = new int[V];
        Arrays.fill(dist, (int) 1e8);
        dist[S] = 0;
        for (int i = 1; i <= V - 1; i++) {
            for (ArrayList<Integer> edge : edges) {
                int u = edge.get(0);
                int v = edge.get(1);
                int w = edge.get(2);
                if (dist[u] != 1e8 && dist[u] + w < dist[v]) {
                    dist[v] = dist[u] + w;
                }
            }
        }
        for (ArrayList<Integer> edge : edges) {
            int u = edge.get(0);
            int v = edge.get(1);
            int w = edge.get(2);
            if (dist[u] != 1e8 && dist[u] + w < dist[v]) {
                int[] ans = new int[1];
                ans[0] = -1;
                return ans;
            }
        }
        return dist;
    }
}
