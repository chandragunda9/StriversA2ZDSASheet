package gfg_leetcode.graphs.learning;

public class CountingGraphs {
    static long count(int n) {
        return (long) Math.pow(2, (double) (n * (n - 1)) / 2);
    }
}
