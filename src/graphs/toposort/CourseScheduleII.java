package graphs.toposort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Collectors;

public class CourseScheduleII {
    public static void main(String[] args) {
        int n = 4, m = 4;
        int[][] prerequisites = {{1, 0},
                {2, 0},
                {3, 1},
                {3, 2}};
        ArrayList<ArrayList<Integer>> al = Arrays.stream(prerequisites).map(a ->
                Arrays.stream(a).boxed().collect(Collectors.toCollection(ArrayList::new))).collect(Collectors.toCollection(ArrayList::new));
        System.out.println(Arrays.toString(findOrder(n, m, al)));
    }

    static int[] findOrder(int n, int m, ArrayList<ArrayList<Integer>> prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            ArrayList<Integer> pre = prerequisites.get(i);
            adj.get(pre.get(1)).add(pre.get(0));
        }
        Queue<Integer> q = new LinkedList<>();
        int[] indeg = new int[n];
        for (ArrayList<Integer> al : adj) {
            for (int ele : al) {
                indeg[ele]++;
            }
        }
        for (int i = 0; i < n; i++) {
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
        return ans.size() < n ? new int[]{} : ans.stream().mapToInt(Integer::intValue).toArray();
    }
}
