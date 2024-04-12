package graphs.otheralgorithms;

import java.util.ArrayList;
import java.util.Stack;

public class KosarajusAlgorithm {
    //finding no.of strongly connected components
    public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj) {
        // storing the vertices according to finish time
        // reverse the graph
        // perform DFS

        //step 1: store the vertices according to finishTimes
        // (which node finished at the last, will be at the top of the stack)
        Stack<Integer> st = new Stack<>();
        boolean[] vis = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                dfs(i, adj, vis, st);
            }
        }

        //step 2: reverse the graph (transposing the graph)
        ArrayList<ArrayList<Integer>> adjT = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adjT.add(new ArrayList<>());
        }
        for (int u = 0; u < V; u++) {
            vis[u] = false;
            ArrayList<Integer> conn = adj.get(u);
            for (Integer v : conn) {
                //that means there is a directed edge from u->v
                adjT.get(v).add(u);
            }
        }

        //step 3:
        int count = 0;
        while (!st.isEmpty()) {
            Integer node = st.pop();
            if (!vis[node]) {
                count++;
                dfs2(node, adjT, vis);
            }
        }
        return count;
    }

    void dfs(int v, ArrayList<ArrayList<Integer>> adj,
             boolean[] vis, Stack<Integer> st) {
        vis[v] = true;
        ArrayList<Integer> conn = adj.get(v);
        for (Integer ele : conn) {
            if (!vis[ele]) {
                dfs(ele, adj, vis, st);
            }
        }
        st.push(v);
    }

    void dfs2(int v, ArrayList<ArrayList<Integer>> adj,
              boolean[] vis) {
        vis[v] = true;
        ArrayList<Integer> conn = adj.get(v);
        for (Integer ele : conn) {
            if (!vis[ele]) {
                dfs2(ele, adj, vis);
            }
        }
    }
}
