package graphs.toposort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class EventualSafeStates {
    List<Integer> method1(int v, List<List<Integer>> adj) {
        boolean[] vis = new boolean[v];
        boolean[] currVis = new boolean[v];
        boolean[] isSafe = new boolean[v];
        for (int i = 0; i < v; i++) {
            if (!vis[i]) {
                dfs(i, vis, currVis, isSafe, adj);
            }
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < isSafe.length; i++) {
            if (isSafe[i])
                ans.add(i);
        }
        return ans;
    }
    List<Integer> eventualSafeNodes(int v, List<List<Integer>> adj) {
        //By using kahns algorithm
        int[] inDeg = new int[v];
        for (List<Integer> al : adj) {
            for (int ele : al) {
                inDeg[ele]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < v; i++) {
            if (inDeg[i] == 0)
                q.add(i);
        }

        List<Integer> ans = new ArrayList<>();
        while (!q.isEmpty()) {
            Integer rem = q.poll();
            ans.add(rem);
            List<Integer> conn = adj.get(rem);
            for (int ele : conn) {
                inDeg[ele]--;
                if (inDeg[ele] == 0) {
                    q.add(ele);
                }
            }
        }
        return ans;
    }

    static boolean dfs(int v, boolean[] vis, boolean[] currVis, boolean[] isSafeNode, List<List<Integer>> adj) {
        vis[v] = true;
        currVis[v] = true;
        isSafeNode[v] = true;
        List<Integer> conn = adj.get(v);
        for (int ele : conn) {
            if (!vis[ele]) {
                if (dfs(ele, vis, currVis, isSafeNode, adj)) {
                    isSafeNode[v] = false;
                    return true;
                }
            } else if (currVis[ele]) {
                isSafeNode[v] = false;
                return true;
            }
        }
        currVis[v] = false;
        return false;
    }
}
