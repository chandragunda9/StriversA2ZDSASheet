package gfg_leetcode.graphs.toposort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CycleDetectionUsingBFS {
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        //By using kahns algorithm
        int[] indeg = new int[V];
        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < adj.size(); i++) {
            ArrayList<Integer> al = adj.get(i);
            for (int ele : al) {
                indeg[ele]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < indeg.length; i++) {
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
//        for (int i = 0; i < indeg.length; i++) {
//            if (indeg[i] != 0)
//                return true;
//        }
        return ans.size() < V;
    }
}
