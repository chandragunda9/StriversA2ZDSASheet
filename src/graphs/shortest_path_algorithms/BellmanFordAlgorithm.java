package graphs.shortest_path_algorithms;

import java.util.Arrays;
import java.util.List;

public class BellmanFordAlgorithm {
    public static int[] bellmonFord(int n, int m, int src, List<List<Integer>> edges) {
        int[] dis = new int[n + 1];
        Arrays.fill(dis, (int) 1e8);
        dis[src] = 0;
        for (int i = 1; i <= n - 1; i++) {
            for (List<Integer> edge : edges) {
                int u = edge.get(0), v = edge.get(1), w = edge.get(2);
                if (dis[u] + w < dis[v]) {
                    dis[v] = dis[u] + w;
                }
            }
        }
        return dis;
    }
}
