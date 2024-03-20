package graphs.topological_sort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AlienDictionary {
    public static String getAlienLanguage(String[] dictionary, int k) {
        List<List<Integer>> adj = new ArrayList<>();
        // k is the no.of starting alphabets
        for (int i = 0; i < k; i++) {
            adj.add(new ArrayList<>());
        }
        int[] indegree = new int[k];
        for (int i = 0; i < dictionary.length - 1; i++) {
            String a = dictionary[i].toLowerCase();
            String b = dictionary[i + 1].toLowerCase();
            for (int j = 0; j < Math.min(a.length(), b.length()); j++) {
                if (a.charAt(j) != b.charAt(j)) {
                    int node1 = a.charAt(j) - 'a';
                    int node2 = b.charAt(j) - 'a';
                    adj.get(node1).add(node2);
                    indegree[node2]++;
                    break;
                }
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            if (indegree[i] == 0)
                q.add(i);
        }

        StringBuilder ans = new StringBuilder();
        while (!q.isEmpty()) {
            Integer rem = q.poll();
            ans.append((char) (rem + (int) ('a')));
            List<Integer> conn = adj.get(rem);
            for (Integer ele : conn) {
                indegree[ele]--;
                if (indegree[ele] == 0) {
                    q.add(ele);
                }
            }
        }
        return ans.toString();
    }
}
