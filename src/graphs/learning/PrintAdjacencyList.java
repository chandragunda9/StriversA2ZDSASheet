package graphs.learning;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrintAdjacencyList {
    public static int[][] printAdjacency(int n, int m, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>(Arrays.asList(i)));
        }
        for (int i = 0; i < m; i++) {
            int[] edge = edges[i];
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        return adj.stream().map(li -> li.stream().mapToInt(Integer::intValue).toArray()).
                toArray(int[][]::new);
    }
}
