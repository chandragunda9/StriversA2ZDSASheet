package arrays.medium;

import java.util.HashMap;
import java.util.Map;

public class CountSubarraysWithGivenSum {
    public static void main(String[] args) {
        int[] arr = {1, 1, 1};
        int k = 2;
        System.out.println(subarraySum(arr, k));
    }

    public static int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> prefixSumCounts = new HashMap<>();
        int sum = 0, count = 0;
        prefixSumCounts.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (prefixSumCounts.containsKey(sum - k)) {
                count += prefixSumCounts.get(sum - k);
            }
            prefixSumCounts.put(sum, prefixSumCounts.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}
