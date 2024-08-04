package arrays.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NextPermutation {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(nextPermutation(nums.length, nums));
//        nextPermutation(nums);
//        System.out.println(Arrays.toString(nums));
    }

    public static void nextPermutation(int[] nums) {
        int breakpoint = -1, n = nums.length;
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                breakpoint = i;
                break;
            }
        }
        if (breakpoint != -1) {
            for (int i = n - 1; i > breakpoint; i--) {
                if (nums[i] > nums[breakpoint]) {
                    swap(nums, i, breakpoint);
                    break;
                }
            }
        }
        reverse(nums, breakpoint + 1, n - 1);
    }

    static void reverse(int[] nums, int i, int j) {
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    static void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    static List<Integer> nextPermutation(int N, int arr[]) {
        int breakpoint = -1, n = arr.length;
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] < arr[i + 1]) {
                breakpoint = i;
                break;
            }
        }
        if (breakpoint != -1) {
            for (int i = n - 1; i > breakpoint; i--) {
                if (arr[i] > arr[breakpoint]) {
                    swap(arr, i, breakpoint);
                    break;
                }
            }
        }
        reverse(arr, breakpoint + 1, n - 1);
        List<Integer> ans = new ArrayList<>();
        for (int j : arr) {
            ans.add(j);
        }
        return ans;
    }
}
