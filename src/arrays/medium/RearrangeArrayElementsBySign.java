package arrays.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RearrangeArrayElementsBySign {
    public static void main(String[] args) {
        int[] arr = {3, 1, -2, -5, 2, -4};
        //if equal no.of positives and negatives
        System.out.println(Arrays.toString(method2(arr)));
        System.out.println(Arrays.toString(method1(arr)));
        //if not equal no.os positives and negatives
        int[] nums = {-5, -2, 5, 2, 4, 7, 1, 8, 0, -8};
        rearrange(nums, nums.length);
        System.out.println(Arrays.toString(nums));
    }

    public static int[] method1(int[] nums) {
        int n = nums.length;
        List<Integer> pos = new ArrayList<>(), neg = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0)
                pos.add(nums[i]);
            else
                neg.add(nums[i]);
        }
        for (int i = 0; i < n / 2; i++) {
            nums[2 * i] = pos.get(i);
            nums[2 * i + 1] = neg.get(i);
        }
        return nums;
    }

    public static int[] method2(int[] nums) {
        int n = nums.length, posInd = 0, negInd = 1;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                ans[posInd] = nums[i];
                posInd += 2;
            } else {
                ans[negInd] = nums[i];
                negInd += 2;
            }
        }
        return ans;
    }

    static void rearrange(int arr[], int n) {
        List<Integer> pos = new ArrayList<>();
        List<Integer> neg = new ArrayList<>();
        for (int ele : arr) {
            if (ele >= 0)
                pos.add(ele);
            else
                neg.add(ele);
        }
        if (pos.size() > neg.size()) {
            for (int i = 0; i < neg.size(); i++) {
                arr[2 * i] = pos.get(i);
                arr[2 * i + 1] = neg.get(i);
            }
            int ind = neg.size() * 2;
            for (int i = neg.size(); i < pos.size(); i++) {
                arr[ind] = pos.get(i);
                ind++;
            }
        } else {
            for (int i = 0; i < pos.size(); i++) {
                arr[2 * i] = pos.get(i);
                arr[2 * i + 1] = neg.get(i);
            }
            int ind = pos.size() * 2;
            for (int i = pos.size(); i < neg.size(); i++) {
                arr[ind] = neg.get(i);
                ind++;
            }
        }
    }
}
