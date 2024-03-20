package graphs.topological_sort;

import java.util.*;
import java.util.stream.Collectors;

public class DetectCycleInDirectedGraphUsingBFS {
    public static void main(String[] args) {
        int[][] arr = {{1, 2}, {4, 1}, {2, 4}, {3, 4}, {5, 2}, {1, 3}};
        int n = 5;
        ArrayList<ArrayList<Integer>> edges = Arrays.stream(arr).map(innerArray -> Arrays.stream(innerArray)
                .boxed().collect(Collectors.toCollection(ArrayList::new))).collect(Collectors.toCollection(ArrayList::new));
        System.out.println(detectCycleInDirectedGraph(n, edges));
    }

    public static boolean detectCycleInDirectedGraph(int n, ArrayList<ArrayList<Integer>> edges) {
        //By using kahns algorithm (finding topological sort)
        List<Integer> ans = new ArrayList<>();
        //Build adjacency list
        List<List<Integer>> adj = new ArrayList<>();
        int[] indegree = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        for (ArrayList<Integer> edge : edges) {
            adj.get(edge.get(0)).add(edge.get(1));
            indegree[edge.get(1)]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }
        while (!q.isEmpty()) {
            Integer rem = q.poll();
            ans.add(rem);
            List<Integer> conn = adj.get(rem);
            for (Integer ele : conn) {
                indegree[ele]--;
                if (indegree[ele] == 0)
                    q.add(ele);
            }
        }
        return ans.size() < n;
    }
}
