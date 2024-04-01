package graphs.shortest_path_algorithms;

import java.util.ArrayList;
import java.util.Arrays;

public class FindTheCityWithSmallestNoNeighbors {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> edges = new ArrayList<>();
        int n = 5, m = 5, threshold = 3;
        edges.add(new ArrayList<>(Arrays.asList(0, 1, 1)));
        edges.add(new ArrayList<>(Arrays.asList(1, 2, 1)));
        edges.add(new ArrayList<>(Arrays.asList(2, 3, 3)));
        edges.add(new ArrayList<>(Arrays.asList(3, 4, 1)));
        edges.add(new ArrayList<>(Arrays.asList(0, 3, 3)));
        System.out.println(findTheCity(n, edges, threshold));
    }

    public static int findTheCity(int n, ArrayList<ArrayList<Integer>> edges, int distanceThreshold) {
        //by using all pairs shortest path algorithm (floyd warshall algorithm)
        //build adjacency matrix
        int[][] adj = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(adj[i], Integer.MAX_VALUE);
        }
        for (ArrayList<Integer> edge : edges) {
            adj[edge.get(0)][edge.get(1)] = edge.get(2);
            adj[edge.get(1)][edge.get(0)] = edge.get(2);
        }
        for (int i = 0; i < n; i++) {
            adj[i][i] = 0;
        }
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (i == k || j == k)
                        continue;
                    if (adj[i][k] != Integer.MAX_VALUE && adj[k][j] != Integer.MAX_VALUE)
                        adj[i][j] = Math.min(adj[i][j], adj[i][k] + adj[k][j]);
                }
            }
        }
        int city = -1, count = n + 1;
        for (int i = 0; i < n; i++) {
            int c = 0;
            for (int j = 0; j < n; j++) {
                if (adj[i][j] <= distanceThreshold)
                    c++;
            }
            if (c <= count) {
                city = i;
                count = c;
            }
        }
        return city;
    }
}
