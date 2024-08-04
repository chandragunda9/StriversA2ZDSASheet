package arrays.medium;

import java.util.HashMap;

public class TwoSum {
    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 1};
        int sum = 2;
        System.out.println(getPairsCount(arr, sum));
    }

    static int getPairsCount(int[] arr, int sum) {
        HashMap<Integer, Integer> has = new HashMap<>();
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (has.containsKey(sum - arr[i])) {
                count += has.get(sum - arr[i]);
            }
            has.put(arr[i], has.getOrDefault(arr[i], 0) + 1);
        }
        return count;
    }

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> has = new HashMap<>();
        int[] ans = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (has.containsKey(target - nums[i])) {
                ans[0] = has.get(target - nums[i]);
                ans[1] = i;
                break;
            }
            has.put(nums[i], i);
        }
        return ans;
    }
}
