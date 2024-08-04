package graphs.mst_disjointset;

import java.util.HashSet;
import java.util.Set;

public class MaximumStoneRemoval {
    public static void main(String[] args) {
        int[][] stoneLocations = {{0, 0}, {0, 1}, {1, 0}, {1, 2}, {2, 1}, {2, 2}};
        int n = 6;
        System.out.println(maxRemove(stoneLocations, n));
    }

    static int maxRemove(int[][] stones, int n) {
        int maxRow = 0, maxCol = 0;
        for (int[] stone : stones) {
            maxRow = Math.max(maxRow, stone[0]);
            maxCol = Math.max(maxCol, stone[1]);
        }
        DisjointSet dis = new DisjointSet(maxRow + maxCol + 1);
        Set<Integer> stoneNodes = new HashSet<>();
        for (int[] stone : stones) {
            int nodeRow = stone[0];
            int nodeCol = stone[1] + maxRow + 1;
            dis.unionBySize(nodeRow, nodeCol);
            stoneNodes.add(nodeRow);
            stoneNodes.add(nodeCol);
        }
        int noOfComponents = 0;
        for (int stoneNode : stoneNodes) {
            if (dis.findParent(stoneNode) == stoneNode)
                noOfComponents++;
        }
        return n - noOfComponents;
    }
}
