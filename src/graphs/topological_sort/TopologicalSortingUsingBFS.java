package graphs.topological_sort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TopologicalSortingUsingBFS {
    public static List<Integer> topologicalSort(int[][] edges, int e, int v) {
        List<List<Integer>> adj = new ArrayList<>();
        int[] inDegree = new int[v];
        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            inDegree[edge[1]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < v; i++) {
            if (inDegree[i] == 0)
                q.add(i);
        }
        List<Integer> ans = new ArrayList<>();
        while (!q.isEmpty()) {
            Integer rem = q.poll();
            ans.add(rem);
            List<Integer> conn = adj.get(rem);
            for (Integer ele : conn) {
                inDegree[ele]--;
                if (inDegree[ele] == 0)
                    q.add(ele);
            }
        }
        return ans;
    }
}
