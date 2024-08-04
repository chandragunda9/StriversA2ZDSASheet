package graphs.other_algorithms;

import java.util.ArrayList;
import java.util.Stack;

public class KosarajusAlgorithm {
    public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj) {
        //step 1
        //sort the nodes according to finish time in stack
        boolean[] vis = new boolean[V];
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < V; i++) {
            if (!vis[i])
                dfs1(i, vis, adj, st);
        }
        //step 2
        //reverse the graph
        ArrayList<ArrayList<Integer>> revAdj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            revAdj.add(new ArrayList<>());
            vis[i] = false;
        }
        for (int i = 0; i < V; i++) {
            ArrayList<Integer> al = adj.get(i);
            for (int conn : al) {
                revAdj.get(conn).add(i);
            }
        }
        //step 3
        //count the scc
        int count = 0;
        while (!st.isEmpty()) {
            int ele = st.pop();
            if (!vis[ele]) {
                dfs2(ele, vis, revAdj);
                count++;
            }
        }
        return count;
    }

    static void dfs1(int v, boolean[] vis, ArrayList<ArrayList<Integer>> adj, Stack<Integer> st) {
        vis[v] = true;
        ArrayList<Integer> conn = adj.get(v);
        for (int ele : conn) {
            if (!vis[ele])
                dfs1(ele, vis, adj, st);
        }
        st.push(v);
    }

    static void dfs2(int v, boolean[] vis, ArrayList<ArrayList<Integer>> adj) {
        vis[v] = true;
        ArrayList<Integer> conn = adj.get(v);
        for (int ele : conn) {
            if (!vis[ele])
                dfs2(ele, vis, adj);
        }
    }
}
