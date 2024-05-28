package gfg_leetcode.arrays.easy;

import java.util.Arrays;

public class RightRotateByDPlaces {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;
        rotate(arr, k);
        System.out.println(Arrays.toString(arr));
    }

    public static void method2(int[] nums, int d) {
        int n = nums.length;
        d = d % n;
        d = (n - d) % n;
        int gcd = findGdc(n, d);
        for (int i = 0; i < gcd; i++) {
            int j = i;
            int ele = nums[i];
            while (true) {
                int k = (j + d) % n;
//                if (k >= n)
//                    k = k - n;
                if (k == i)
                    break;
                nums[j] = nums[k];
                j = k;
            }
            nums[j] = ele;
        }
    }

    static int findGdc(int a, int b) {
        if (b == 0)
            return a;
        return findGdc(b, a % b);
    }

    static void rotate(int[] nums, int d) {
        d = d % nums.length;
        d = (nums.length - d) % nums.length;
        //reverse the first half;
        reverse(nums, 0, d - 1);
        //reverse the sec half
        reverse(nums, d, nums.length - 1);
        //reverse the whole array
        reverse(nums, 0, nums.length - 1);
    }

    static void reverse(int[] arr, int i, int j) {
        while (i < j) {
            int t = arr[i];
            arr[i] = arr[j];
            arr[j] = t;
            i++;
            j--;
        }
    }
}
