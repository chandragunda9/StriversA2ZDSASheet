package arrays.medium;

import java.util.Arrays;
import java.util.List;

public class MaximumScoreFromSubarrayMinimums {
    public static void main(String[] args) {
        Integer[] arr = {4, 3, 1, 5, 6};
        System.out.println(pairWithMaxSum(Arrays.asList(arr)));
    }

    public static int pairWithMaxSum(List<Integer> arr) {
        int maxSum = 0;
        for (int i = 0; i < arr.size() - 1; i++) {
            if (arr.get(i) + arr.get(i + 1) > maxSum) {
                maxSum = arr.get(i) + arr.get(i + 1);
            }
        }
        return maxSum;
    }
}
