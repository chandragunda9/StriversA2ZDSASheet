package practice.graphs.other_algorithms.learning;

import java.util.ArrayList;
import java.util.List;

public class PrintAdjacencyList {
    public static int[][] printAdjacency(int n, int m, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        return adj.stream().map(li -> li.stream().mapToInt(Integer::intValue).toArray())
                .toArray(int[][]::new);
    }
}
