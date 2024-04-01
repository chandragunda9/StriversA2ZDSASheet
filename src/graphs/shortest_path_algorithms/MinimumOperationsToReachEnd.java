package graphs.shortest_path_algorithms;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class MinimumOperationsToReachEnd {
    static class Node {
        int steps, val;

        public Node(int steps, int val) {
            this.steps = steps;
            this.val = val;
        }
    }

    public static int minimumOperations(int n, int start, int end, int[] a) {
        if (start == end)
            return 0;
        int mod = (int) Math.pow(10, 3);
        int[] steps = new int[mod];
        Arrays.fill(steps, Integer.MAX_VALUE);

        Queue<Node> q = new LinkedList<>();
        steps[start] = 0;
        q.add(new Node(0, start % mod));
        while (!q.isEmpty()) {
            Node rem = q.poll();
            if (rem.val == end)
                return rem.steps;
            for (int ele : a) {
                int val = (ele * rem.val) % mod;
                if (rem.steps + 1 < steps[val]) {
                    steps[val] = rem.steps + 1;
                    q.add(new Node(rem.steps + 1, val));
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {2, 5, 7};
        int start = 3, end = 30;
        System.out.println(minimumOperations(arr.length, start, end, arr));
    }
}
