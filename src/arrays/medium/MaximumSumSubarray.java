package arrays.medium;

public class MaximumSumSubarray {
    public static void main(String[] args) {
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray(arr));
    }

    public static int maxSubArray(int[] nums) {
        int sum = 0;
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            maxSum = Math.max(maxSum, sum);
            if (sum < 0)
                sum = 0;
        }
        return maxSum;
    }

    long maxSubarraySum(int[] arr) {
        long sum = 0;
        long maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            maxSum = Math.max(maxSum, sum);
            if (sum < 0)
                sum = 0;
        }
        return maxSum;
    }
}
