package gfg_leetcode.graphs.bfs_dfs_problems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class DetectCycleInUndirectedGraphUsingBFS {
    static class Node {
        int v, p;

        Node(int v, int p) {
            this.v = v;
            this.p = p;
        }
    }

    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] vis = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                if (bfs(i, vis, adj))
                    return true;
            }
        }
        return false;
    }

    static boolean bfs(int v, boolean[] vis, ArrayList<ArrayList<Integer>> adj) {
        //Using BFS
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(v, -1));
        vis[v] = true;
        while (!q.isEmpty()) {
            Node rem = q.poll();
            ArrayList<Integer> conn = adj.get(rem.v);
            for (int ele : conn) {
                if (!vis[ele]) {
                    q.add(new Node(ele, rem.v));
                    vis[ele] = true;
                } else if (ele != rem.p) {
                    return true;
                }
            }
        }
        return false;
    }
}
