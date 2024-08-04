package graphs.mst_disjointset;

public class MinimizeConnections {
    public static void main(String[] args) {
        int[][] conn = {{0, 1}, {0, 2}, {0, 3}, {1, 2}, {1, 3}};
        int numOfNodes = 6;
        System.out.println(minimumConnections(numOfNodes, conn));
    }

    public static int minimumConnections(int n, int[][] connections) {
        DisjointSet dis = new DisjointSet(n);
        int extraEdges = 0;
        for (int[] connection : connections) {
            if (dis.findParent(connection[0]) != dis.findParent(connection[1])) {
                dis.unionBySize(connection[0], connection[1]);
            } else {
                extraEdges++;
            }
        }
        int noOfComponents = 0;
        for (int i = 0; i < n; i++) {
            if (dis.findParent(i) == i)
                noOfComponents++;
        }
        int edgesReq = noOfComponents - 1;
        if (extraEdges >= edgesReq)
            return edgesReq;
        return -1;
    }
}
