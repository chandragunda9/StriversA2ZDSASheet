package graphs.shortest_path;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class MinimumStepsToReachEnd {
    static class Pair {
        int node;
        int steps;

        public Pair(int node, int steps) {
            this.node = node;
            this.steps = steps;
        }
    }

    public static void main(String[] args) {
//        int[] arr = {2, 5, 7};
//        int start = 3, end = 30;
        int[] arr = {3, 4, 65};
        int start = 7, end = 66175;
        System.out.println(minimumMultiplications(arr, start, end));
    }

    static int minimumMultiplications(int[] arr, int start, int end) {
        int mod = 100000;
        int[] steps = new int[mod];
        Arrays.fill(steps, Integer.MAX_VALUE);
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(start, 0));
        steps[start] = 0;
        while (!q.isEmpty()) {
            Pair rem = q.poll();
            if (rem.node == end)
                return rem.steps;
            for (int i = 0; i < arr.length; i++) {
                int mulValue = rem.node * arr[i] % mod;
                if (rem.steps + 1 < steps[mulValue]) {
//                if (steps[mulValue]==Integer.MAX_VALUE) {
                    steps[mulValue] = rem.steps + 1;
                    q.add(new Pair(mulValue, steps[mulValue]));
                }
            }
        }
        return -1;
    }
}
