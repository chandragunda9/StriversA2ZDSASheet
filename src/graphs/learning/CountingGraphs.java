package graphs.learning;

public class CountingGraphs {
    public static int countingGraphs(int N) {
        //there can be an edge ot no edge  blw pair of vertices
        //there are two possibilities for each edge - present or not present
        return (int) Math.pow(2, (double) (N * (N - 1)) / 2);
    }
}
