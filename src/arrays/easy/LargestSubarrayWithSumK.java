package arrays.easy;

import java.util.HashMap;
import java.util.Map;

public class LargestSubarrayWithSumK {
    public static void main(String[] args) {
//        int[] arr = {-1, 2, 3};
//        int k = 6;
        int[] arr = {10, 5, 2, 7, 1, 9};
        int k = 15;
        System.out.println(lenOfLongSubarr(arr, arr.length, k));
    }

    public static int lenOfLongSubarr(int A[], int N, int K) {
        Map<Integer, Integer> prefixSum = new HashMap<>();
        int maxLen = 0, sum = 0;
        prefixSum.put(0, -1);
        for (int i = 0; i < N; i++) {
            sum += A[i];
            if (prefixSum.containsKey(sum - K)) {
                maxLen = Math.max(maxLen, i - prefixSum.get(sum - K));
            }
            if (!prefixSum.containsKey(sum)) {
                prefixSum.put(sum, i);
            }
        }
        return maxLen;
    }
}
