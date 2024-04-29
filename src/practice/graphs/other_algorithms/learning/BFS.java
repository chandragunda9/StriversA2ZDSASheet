package practice.graphs.other_algorithms.learning;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS {
    public static List<Integer> bfsTraversal(int n, List<List<Integer>> adj) {
        List<Integer> ans = new ArrayList<>();
        boolean[] vis = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        vis[0] = true;
        while (!q.isEmpty()) {
            Integer rem = q.poll();
            ans.add(rem);
            List<Integer> conn = adj.get(rem);
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
