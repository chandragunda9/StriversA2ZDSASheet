package graphs.topological_sort;

import java.util.*;
import java.util.stream.Collectors;

public class CourseSchedule2 {
    public static void main(String[] args) {
        int[][] arr = {{2, 1}, {3, 1}, {4, 2}, {4, 3}};
        int n = 4;
        List<List<Integer>> pre = Arrays.stream(arr).map(innerArr -> Arrays.stream(innerArr).boxed().
                collect(Collectors.toCollection(ArrayList::new))).collect(Collectors.toCollection(ArrayList::new));
        System.out.println(findSchedule(n, pre));
    }

    public static List<Integer> findSchedule(int numCourses, List<List<Integer>> prerequisites) {
        //build adjacency list
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        int[] indegree = new int[numCourses + 1];
        for (List<Integer> p : prerequisites) {
            adj.get(p.get(1)).add(p.get(0));
            indegree[p.get(0)]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= numCourses; i++) {
            if (indegree[i] == 0)
                q.add(i);
        }
        List<Integer> ans = new ArrayList<>();
        while (!q.isEmpty()) {
            Integer rem = q.poll();
            ans.add(rem);
            List<Integer> conn = adj.get(rem);
            for (Integer ele : conn) {
                indegree[ele]--;
                if (indegree[ele] == 0) {
                    q.add(ele);
                }
            }
        }
        return ans;
    }
}
