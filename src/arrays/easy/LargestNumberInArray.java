package arrays.easy;

public class LargestNumberInArray {
    public static int largest(int n, int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, arr[i]);
        }
        return max;
    }
}
