package graphs.toposort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CourseScheduleI {
    public static void main(String[] args) {
        int n = 4, p = 3;
        int[][] arr = {{1, 0}, {2, 1}, {3, 2}};
        System.out.println(isPossible(n, p, arr));
    }

    public static boolean isPossible(int N, int P, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < P; i++) {
            int[] pre = prerequisites[i];
            adj.get(pre[1]).add(pre[0]);
        }
        Queue<Integer> q = new LinkedList<>();
        int[] indeg = new int[N];
        for (ArrayList<Integer> al : adj) {
            for (int ele : al) {
                indeg[ele]++;
            }
        }
        for (int i = 0; i < N; i++) {
            if (indeg[i] == 0)
                q.add(i);
        }

        ArrayList<Integer> ans = new ArrayList<>();
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
        return ans.size() == N;
    }
}
