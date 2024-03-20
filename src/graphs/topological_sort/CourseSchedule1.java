package graphs.topological_sort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule1 {
    public static void main(String[] args) {
        int[][] pre = {{1, 0}};
        int n = 2;
        CourseSchedule1 c = new CourseSchedule1();
        System.out.println(c.canFinish(n, pre));
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //build adjacency list
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        int[] indegree = new int[numCourses];
        for (int[] p : prerequisites) {
            adj.get(p[1]).add(p[0]);
            indegree[p[0]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
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
        return ans.size() == numCourses;
    }
}
