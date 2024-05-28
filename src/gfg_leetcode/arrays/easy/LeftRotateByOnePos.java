package gfg_leetcode.arrays.easy;

import java.util.Arrays;

public class LeftRotateByOnePos {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        rotate(arr, 2);
        System.out.print(Arrays.toString(arr));
    }

    public static void rotate(int[] nums, int d) {
        int n = nums.length;
        d = d % n;
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
}
