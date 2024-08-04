package graphs.mst_disjointset;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class KruskalsAlgorithm {
    static class Edge {
        int weight, u, v;

        public Edge(int weight, int u, int v) {
            this.weight = weight;
            this.u = u;
            this.v = v;
        }
    }

    static int spanningTree(int V, int E, List<List<int[]>> adj) {
        List<Edge> edges = new ArrayList<>();
        for (int i = 0; i < adj.size(); i++) {
            List<int[]> conn = adj.get(i);
            for (int[] ele : conn) {
                int adjNode = ele[0];
                int weight = ele[1];
                Edge edge = new Edge(weight, i, adjNode);
                edges.add(edge);
            }
        }
        edges.sort(Comparator.comparingInt(edge -> edge.weight));
        DisjointSet dis = new DisjointSet(V);
        int mstWeight = 0;
        for (Edge edge : edges) {
            if (dis.findParent(edge.u) != dis.findParent(edge.v)) {
                mstWeight += edge.weight;
                dis.unionBySize(edge.u, edge.v);
            }
        }
        return mstWeight;
    }
}
