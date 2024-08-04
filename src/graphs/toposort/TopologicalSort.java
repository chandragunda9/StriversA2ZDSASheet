package graphs.toposort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TopologicalSort {
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {
        List<Integer> ans = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        int[] indeg = new int[V];
        for (ArrayList<Integer> al : adj) {
            for (int ele : al) {
                indeg[ele]++;
            }
        }
        for (int i = 0; i < V; i++) {
            if (indeg[i] == 0)
                q.add(i);
        }

        while (!q.isEmpty()) {
            Integer rem = q.poll();
            ans.add(rem);
            ArrayList<Integer> conn = adj.get(rem);
            for (int ele : conn) {
                indeg[ele]--;
                if (indeg[ele] == 0)
                    q.add(ele);
            }
        }
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }
}
