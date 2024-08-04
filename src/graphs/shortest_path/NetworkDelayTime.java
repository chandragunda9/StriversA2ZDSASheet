package graphs.shortest_path;

import java.util.*;

public class NetworkDelayTime {
    static class Pair {
        int node, time;

        public Pair(int node, int time) {
            this.node = node;
            this.time = time;
        }
    }

    public static void main(String[] args) {
        int n = 4, k = 2;
        int[][] times = {{2, 1, 1}, {2, 3, 1}, {3, 4, 1}};
        System.out.println(networkDelayTime(times, n, k));
    }

    public static int networkDelayTime(int[][] times, int n, int k) {
        Queue<Pair> q = new LinkedList<>();
        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] time : times) {
            adj.get(time[0]).add(new Pair(time[1], time[2]));
        }
        int[] minTimes = new int[n + 1];
        Arrays.fill(minTimes, Integer.MAX_VALUE);

        q.add(new Pair(k, 0));
        minTimes[k] = 0;
        while (!q.isEmpty()) {
            Pair rem = q.poll();
            List<Pair> conn = adj.get(rem.node);
            for (Pair ele : conn) {
                if (minTimes[rem.node] + ele.time < minTimes[ele.node]) {
                    minTimes[ele.node] = minTimes[rem.node] + ele.time;
                    q.add(new Pair(ele.node, minTimes[ele.node]));
                }
            }
        }
        int ans = 0;
        for (int i = 1; i < minTimes.length; i++) {
            if (minTimes[i] == Integer.MAX_VALUE)
                return -1;
            ans = Math.max(ans, minTimes[i]);
        }
        return ans;
    }
}
