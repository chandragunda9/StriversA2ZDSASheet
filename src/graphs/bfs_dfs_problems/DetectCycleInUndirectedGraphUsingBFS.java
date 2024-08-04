package graphs.bfs_dfs_problems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class DetectCycleInUndirectedGraphUsingBFS {
    static class Node {
        int val, parent;

        public Node(int val, int parent) {
            this.val = val;
            this.parent = parent;
        }
    }

    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] vis = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                if (bfs(i, adj, vis))
                    return true;
            }
        }
        return false;
    }

    static boolean bfs(int v, ArrayList<ArrayList<Integer>> adj, boolean[] vis) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(v, -1));
        vis[v] = true;
        while (!q.isEmpty()) {
            Node rem = q.poll();
            ArrayList<Integer> conn = adj.get(rem.val);
            for (int ele : conn) {
                if (!vis[ele]) {
                    if (bfs(ele, adj, vis))
                        return true;
                } else if (ele != rem.parent)
                    return true;
            }
        }
        return false;
    }
}
