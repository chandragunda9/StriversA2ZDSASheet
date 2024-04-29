package practice.graphs.other_algorithms.learning;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class DFS {
    public static void main(String[] args) {
        int v = 5;
        int e = 4;
        int[][] edges = {{0, 2}, {0, 1}, {1, 2}, {3, 4}};
        ArrayList<ArrayList<Integer>> al = Arrays.stream(edges).map(arr -> Arrays.stream(arr).boxed()
                .collect(Collectors.toCollection(ArrayList::new))).collect(Collectors.toCollection(ArrayList::new));
        System.out.println(depthFirstSearch1(v, e, al));
    }

    public static ArrayList<ArrayList<Integer>> depthFirstSearch1(int v, int e, ArrayList<ArrayList<Integer>> edges) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        List<List<Integer>> adj = new ArrayList<>();
        boolean[] vis = new boolean[v];
        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }
        for (ArrayList<Integer> edge : edges) {
            adj.get(edge.get(0)).add(edge.get(1));
            adj.get(edge.get(1)).add(edge.get(0));
        }

        for (int i = 0; i < v; i++) {
            if (!vis[i]) {
                ArrayList<Integer> temp = new ArrayList<>();
                Stack<Integer> st = new Stack<>();
                st.push(i);
                vis[i] = true;
                while (!st.isEmpty()) {
                    Integer rem = st.pop();
                    temp.add(rem);
                    List<Integer> conn = adj.get(rem);
                    for (int ele : conn) {
                        if (!vis[ele]) {
                            st.push(ele);
                            vis[ele] = true;
                        }
                    }
                }
                ans.add(temp);
            }
        }
        return ans;
    }

    public static ArrayList<ArrayList<Integer>> depthFirstSearch(int v, int e, ArrayList<ArrayList<Integer>> edges) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        List<List<Integer>> adj = new ArrayList<>();
        boolean[] vis = new boolean[v];
        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }
        for (ArrayList<Integer> edge : edges) {
            adj.get(edge.get(0)).add(edge.get(1));
            adj.get(edge.get(1)).add(edge.get(0));
        }
        for (int i = 0; i < v; i++) {
            if (!vis[i]) {
                ArrayList<Integer> al = new ArrayList<>();
                dfs(i, vis, adj, al);
                ans.add(al);
            }
        }
        return ans;
    }

    static void dfs(int v, boolean[] vis, List<List<Integer>> adj, ArrayList<Integer> al) {
        vis[v] = true;
        al.add(v);
        List<Integer> conn = adj.get(v);
        for (int ele : conn) {
            if (!vis[ele]) {
                dfs(ele, vis, adj, al);
            }
        }
    }
}
