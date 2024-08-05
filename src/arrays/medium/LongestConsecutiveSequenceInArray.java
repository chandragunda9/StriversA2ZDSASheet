package arrays.medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequenceInArray {
    public static void main(String[] args) {
        int[] arr = {2, 6, 1, 9, 4, 5, 3};
        System.out.println(longestConsecutive(arr));
        System.out.println(findLongestConseqSubseq(arr, arr.length));
        System.out.println(method2(arr, arr.length));
    }

    public static int longestConsecutive(int[] nums) {
        int maxCount = 0;
        Set<Integer> se = new HashSet<>();
        for (int ele : nums) {
            se.add(ele);
        }
        for (int seVal : se) {
            if (se.contains(seVal - 1))
                continue;
            int ele = seVal, count = 0;
            while (se.contains(ele)) {
                count += 1;
                ele += 1;
            }
            maxCount = Math.max(maxCount, count);
        }
        return maxCount;
    }

    static int findLongestConseqSubseq(int arr[], int N) {
        int maxCount = 0;
        Set<Integer> se = new HashSet<>();
        for (int ele : arr) {
            se.add(ele);
        }
        for (int seVal : se) {
            if (se.contains(seVal - 1))
                continue;
            int ele = seVal, count = 0;
            while (se.contains(ele)) {
                count += 1;
                ele += 1;
            }
            maxCount = Math.max(maxCount, count);
        }
        return maxCount;
    }

    static int method2(int arr[], int N) {
        Arrays.sort(arr);
        int lastSmaller = Integer.MIN_VALUE;
        int count = 0, maxCount = 1;
        for (int i = 0; i < N; i++) {
            if (arr[i] - 1 == lastSmaller) {
                count++;
                lastSmaller = arr[i];
            } else if (arr[i] != lastSmaller) {
                count = 1;
                lastSmaller = arr[i];
            }
            maxCount = Math.max(maxCount, count);
        }
        return maxCount;
    }
}
