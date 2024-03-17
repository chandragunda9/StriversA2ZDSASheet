package bfs_dfs_problems;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DetectCycleInAnUndirectedGraphUsingBFS {
    static class Graph {
        static class Node {
            int v, parent;

            public Node(int v, int parent) {
                this.v = v;
                this.parent = parent;
            }
        }

        boolean detectCycle(int V, List<List<Integer>> adj) {
            boolean[] vis = new boolean[V];
            for (int i = 0; i < V; i++) {
                if (!vis[i]) {
                    if (bfs(adj, i, vis))
                        return true;
                }
            }
            return false;
        }

        static boolean bfs(List<List<Integer>> adj, int v, boolean[] vis) {
            Queue<Node> q = new LinkedList<>();
            q.add(new Node(v, -1));
            vis[v] = true;
            while (!q.isEmpty()) {
                Node temp = q.poll();
                List<Integer> conn = adj.get(temp.v);
                for (Integer ele : conn) {
                    if (!vis[ele]) {
                        q.add(new Node(ele, temp.v));
                        vis[ele] = true;
                    } else if (ele != temp.parent)
                        return true;
                }
            }
            return false;
        }
    }
}
