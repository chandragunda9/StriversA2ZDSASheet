package graphs.bfs_dfs_problems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DetectCycleInDirectedGraphUsingKahnsAlgo {
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        Queue<Integer> q = new LinkedList<>();
        List<Integer> ans = new ArrayList<>();
        int[] inDeg = new int[V];
        for (ArrayList<Integer> al : adj) {
            for (int ele : al) {
                inDeg[ele]++;
            }
        }
        for (int i = 0; i < V; i++) {
            if (inDeg[i] == 0) {
                q.add(i);
            }
        }
        while (!q.isEmpty()) {
            Integer rem = q.poll();
            ans.add(rem);
            ArrayList<Integer> conn = adj.get(rem);
            for (int ele : conn) {
                inDeg[ele]--;
                if (inDeg[ele] == 0)
                    q.add(ele);
            }
        }
        return ans.size() < V;
    }
}
