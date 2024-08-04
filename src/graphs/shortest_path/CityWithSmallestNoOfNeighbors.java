package graphs.shortest_path;

import java.util.Arrays;

public class CityWithSmallestNoOfNeighbors {
    public static void main(String[] args) {
        int[][] edges = {{0, 1, 3},
                {1, 2, 1},
                {1, 3, 4},
                {2, 3, 1}};
        int n = 4, e = 4, distanceThreshold = 4;
        System.out.println(findCity(n, e, edges, distanceThreshold));
    }

    static int findCity(int n, int m, int[][] edges, int distanceThreshold) {
        int[][] cities = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(cities[i], Integer.MAX_VALUE);
            cities[i][i] = 0;
        }
        for (int[] edge : edges) {
            cities[edge[0]][edge[1]] = edge[2];
            cities[edge[1]][edge[0]] = edge[2];
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (cities[i][k] != Integer.MAX_VALUE && cities[k][j] != Integer.MAX_VALUE) {
                        cities[i][j] = Math.min(cities[i][j], cities[i][k] + cities[k][j]);
                    }
                }
            }
        }
        int ind = -1, noOfCitiesReachable = Integer.MAX_VALUE;
        for (int cityInd = 0; cityInd < n; cityInd++) {
            int count = 0;
            for (int adjCityInd = 0; adjCityInd < n; adjCityInd++) {
                if (cityInd == adjCityInd)
                    continue;
                if (cities[cityInd][adjCityInd] <= distanceThreshold)
                    count++;
            }
            if (count <= noOfCitiesReachable) {
                noOfCitiesReachable = count;
                ind = cityInd;
            }
        }
        return ind;
    }
}
