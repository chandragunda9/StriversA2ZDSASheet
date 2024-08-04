package graphs.learning;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> ans = new ArrayList<>();
        boolean[] vis = new boolean[V];
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        vis[0] = true;
        while (!q.isEmpty()) {
            Integer rem = q.poll();
            ans.add(rem);
            ArrayList<Integer> conn = adj.get(rem);
            for (int ele : conn) {
                if (!vis[ele]) {
                    q.add(ele);
                    vis[ele] = true;
                }
            }
        }
        return ans;
    }
}
