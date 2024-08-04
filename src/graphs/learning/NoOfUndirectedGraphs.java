package graphs.learning;

public class NoOfUndirectedGraphs {
    static long count(int n) {
        return (long) Math.pow(2, (double) (n * (n - 1)) / 2);
    }
}
