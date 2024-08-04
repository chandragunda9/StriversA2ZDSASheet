package graphs.shortest_path;

import java.util.*;

public class NumberOfWaysToArriveAtDestination {

    static class Pair {
        int node;
        long dist;

        public Pair(int node, long dist) {
            this.node = node;
            this.dist = dist;
        }
    }

    public static void main(String[] args) {
//        int[][] roads = {{0, 6, 7}, {0, 1, 2}, {1, 2, 3}, {1, 3, 3}, {6, 3, 3}, {3, 5, 1}, {6, 5, 1}, {2, 5, 1}, {0, 4, 5}, {4, 6, 2}};
//        int n = 7;

        int[][] roads = {{0, 1, 1000000000}, {0, 3, 1000000000}, {1, 3, 1000000000},
                {1, 2, 1000000000}, {1, 5, 1000000000}, {3, 4, 1000000000},
                {4, 5, 1000000000}, {2, 5, 1000000000}};
        int n = 6;
        List<List<Integer>> li = Arrays.stream(roads).map(a -> Arrays.stream(a).boxed().toList()).toList();
        System.out.println(countPaths(n, li));
    }

    static int countPaths(int n, List<List<Integer>> roads) {
        int mod = (int) 1e9 + 7;
        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (List<Integer> road : roads) {
            adj.get(road.get(0)).add(new Pair(road.get(1), road.get(2)));
            adj.get(road.get(1)).add(new Pair(road.get(0), road.get(2)));
        }

        long[] minDist = new long[n];
        Arrays.fill(minDist, Integer.MAX_VALUE);
        int[] ways = new int[n];
        Queue<Pair> q = new PriorityQueue<>(Comparator.comparingLong(a -> a.dist));
        q.add(new Pair(0, 0));
        minDist[0] = 0;
        ways[0] = 1;
        while (!q.isEmpty()) {
            Pair rem = q.poll();
            List<Pair> conn = adj.get(rem.node);
            for (Pair ele : conn) {
                if (rem.dist + ele.dist < minDist[ele.node]) {
                    minDist[ele.node] = rem.dist + ele.dist;
                    q.add(new Pair(ele.node, minDist[ele.node]));
                    ways[ele.node] = ways[rem.node];
                } else if (rem.dist + ele.dist == minDist[ele.node]) {
                    ways[ele.node] = (ways[ele.node] + ways[rem.node]) % mod;
                }
            }
        }
        return ways[n - 1];
    }
}
