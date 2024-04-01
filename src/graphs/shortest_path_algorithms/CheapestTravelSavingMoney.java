package graphs.shortest_path_algorithms;

import java.util.*;
import java.util.stream.Collectors;

public class CheapestTravelSavingMoney {
    static class Node {
        int v, dist;

        public Node(int v, int dist) {
            this.v = v;
            this.dist = dist;
        }
    }

    static class DistWithStop {
        int dist, stops, v;

        public DistWithStop(int dist, int stops, int v) {
            this.dist = dist;
            this.stops = stops;
            this.v = v;
        }
    }

    public static int savingMoney(int n, int source, int destination, int k, List<List<Integer>> trains) {
        //build adjacency list
        List<List<Node>> adj = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        for (List<Integer> edge : trains) {
            adj.get(edge.get(0)).add(new Node(edge.get(1), edge.get(2)));
        }
        int[] minDist = new int[n];
        Arrays.fill(minDist, Integer.MAX_VALUE);
        minDist[source] = 0;

        Queue<DistWithStop> q = new PriorityQueue<>((a, b) -> a.stops != b.stops ? Integer.compare(a.stops, b.stops) :
                Integer.compare(a.dist, b.dist));

        q.add(new DistWithStop(0, 0, source));
        while (!q.isEmpty()) {
            DistWithStop rem = q.poll();
            if (rem.stops > k)
                continue;
            List<Node> conn = adj.get(rem.v);
            for (Node ele : conn) {
                if (rem.dist + ele.dist < minDist[ele.v] && rem.stops <= k) {
                    q.add(new DistWithStop(rem.dist + ele.dist, rem.stops + 1, ele.v));
                    minDist[ele.v] = rem.dist + ele.dist;
                }
            }
        }
        return minDist[destination] == Integer.MAX_VALUE ? -1 : minDist[destination];
    }

    public static void main(String[] args) {
        List<List<Integer>> trains = new ArrayList<>();
//        trains.add(Arrays.asList(0, 1, 5));
//        trains.add(Arrays.asList(1, 3, 50));
//        trains.add(Arrays.asList(0, 2, 10));
//        trains.add(Arrays.asList(2, 3, 10));
//        int k = 2, source = 0, dst = 3, n = 4;
        trains.add(Arrays.asList(0, 1, 5));
        trains.add(Arrays.asList(0, 3, 2));
        trains.add(Arrays.asList(3, 1, 2));
        trains.add(Arrays.asList(1, 4, 1));
        trains.add(Arrays.asList(1, 2, 5));
        trains.add(Arrays.asList(4, 2, 1));
        int k = 2, source = 0, dst = 2, n = 5;
        System.out.println(savingMoney(n, source, dst, k, trains));
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<Integer>> li = Arrays.stream(flights).map(a -> Arrays.stream(a).boxed().collect(Collectors.toList())).toList();
        return savingMoney(n, src, dst, k, li);
    }
}
