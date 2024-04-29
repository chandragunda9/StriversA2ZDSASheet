package practice.graphs.other_algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class KosarajusAlgorithm {
    public static int kosaraju(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] vis = new boolean[V];
        Stack<Integer> st = new Stack<>();
        //doing dfs traversal and storing the stack
        for (int i = 0; i < V; i++) {
            if (!vis[i])
                dfs(i, adj, vis, st);
        }

        ArrayList<ArrayList<Integer>> adjT = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adjT.add(new ArrayList<>());
        }
        //reversing all edges
        for (int ver = 0; ver < adj.size(); ver++) {
            vis[ver] = false;
            ArrayList<Integer> conn = adj.get(ver);
            for (Integer ele : conn) {
                adjT.get(ele).add(ver);
            }
        }

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

    static void dfs(int v, ArrayList<ArrayList<Integer>> adj, boolean[] vis, Stack<Integer> st) {
        vis[v] = true;
        List<Integer> conn = adj.get(v);
        for (Integer ele : conn) {
            if (!vis[ele]) {
                dfs(ele, adj, vis, st);
            }
        }
        st.push(v);
    }

    static void dfs2(int v, ArrayList<ArrayList<Integer>> adj, boolean[] vis) {
        vis[v] = true;
        List<Integer> conn = adj.get(v);
        for (Integer ele : conn) {
            if (!vis[ele]) {
                dfs2(ele, adj, vis);
            }
        }
    }

    public static void main(String[] args) {
        int[][] mat = {{2, 3}, {0}, {1}, {4}, {}};
        ArrayList<ArrayList<Integer>> adj = Arrays.stream(mat).map(arr ->
                        Arrays.stream(arr).boxed().collect(Collectors.toCollection(ArrayList::new)))
                .collect(Collectors.toCollection(ArrayList::new));
        System.out.println(kosaraju(5, adj));
    }
}
