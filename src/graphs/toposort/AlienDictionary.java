package graphs.toposort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AlienDictionary {
    public static void main(String[] args) {
        int n = 5, k = 4;
        String[] dict = {"baa", "abcd", "abca", "cab", "cad"};
        System.out.println(findOrder(dict, n, k));
    }

    public static String findOrder(String[] dictionary, int N, int k) {
        List<List<Integer>> adj = new ArrayList<>();
        int[] inDeg = new int[k];
        for (int i = 0; i < k; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < dictionary.length - 1; i++) {
            String a = dictionary[i];
            String b = dictionary[i + 1];
            for (int j = 0; j < Math.min(a.length(), b.length()); j++) {
                if (a.charAt(j) != b.charAt(j)) {
                    int node1 = a.charAt(j) - 'a';
                    int node2 = b.charAt(j) - 'a';
                    adj.get(node1).add(node2);
                    inDeg[node2]++;
                    break;
                }
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < inDeg.length; i++) {
            if (inDeg[i] == 0)
                q.add(i);
        }
        StringBuilder ans = new StringBuilder();
        while (!q.isEmpty()) {
            Integer rem = q.poll();
            ans.append((char) (rem + (int) 'a'));
            List<Integer> conn = adj.get(rem);
            for (int ele : conn) {
                inDeg[ele]--;
                if (inDeg[ele] == 0)
                    q.add(ele);
            }
        }
        return ans.toString();
    }
}
