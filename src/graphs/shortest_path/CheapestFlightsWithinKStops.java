package graphs.shortest_path;

import java.util.*;

public class CheapestFlightsWithinKStops {
    static class Pair {
        int node;
        int price;

        public Pair(int node, int price) {
            this.node = node;
            this.price = price;
        }
    }

    static class Tuple {
        int stops, node, price;

        public Tuple(int stops, int node, int price) {
            this.stops = stops;
            this.node = node;
            this.price = price;
        }
    }

    public static void main(String[] args) {
        int[][] flights = {{0, 1, 100}, {1, 2, 100}, {2, 0, 100}, {1, 3, 600}, {2, 3, 200}};
        int src = 0, dst = 3;
        int k = 1, n = 4;
        System.out.println(CheapestFLight(n, flights, src, dst, k));
    }

    public static int CheapestFLight(int n, int flights[][], int src, int dst, int k) {
        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] flight : flights) {
            adj.get(flight[0]).add(new Pair(flight[1], flight[2]));
        }
        int[] prices = new int[n];
        Arrays.fill(prices, Integer.MAX_VALUE);
        Queue<Tuple> q = new LinkedList<>();
        q.add(new Tuple(0, src, 0));
        prices[src] = 0;
        while (!q.isEmpty()) {
            Tuple rem = q.poll();
            if (rem.stops > k)
                break;
            List<Pair> conn = adj.get(rem.node);
            for (Pair p : conn) {
                if (rem.price + p.price < prices[p.node] && rem.stops <= k) {
                    prices[p.node] = rem.price + p.price;
                    q.add(new Tuple(rem.stops + 1, p.node, prices[p.node]));
                }
            }
        }
        return prices[dst] != Integer.MAX_VALUE ? prices[dst] : -1;
    }
}