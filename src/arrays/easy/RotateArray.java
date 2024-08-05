package arrays.easy;

import java.util.Arrays;

public class RotateArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        int d = 3;
        method1(arr, d);
        System.out.println(Arrays.toString(arr));
    }

    public static void method1(int[] nums, int d) {
        //By using Juggling algorithm
        int n = nums.length;
        d = d % n;
        d = (n - d) % n;
        int gcd = findGcd(n, d);
        for (int i = 0; i < gcd; i++) {
            int temp = nums[i];
            int j = i, k;
            while (true) {
                k = j + d;
                if (k >= n)
                    k = k - n;
                if (k == i)
                    break;
                nums[j] = nums[k];
                j = k;
            }
            nums[j] = temp;
        }
    }

    static int findGcd(int a, int b) {
        if (b == 0)
            return a;
        return findGcd(b, a % b);
    }

    public void rotate(int[] nums, int d) {
        d = d % nums.length;
        d = (nums.length - d) % nums.length;
        //reverse the first half
        reverse(nums, 0, d - 1);
        //reverse the second half
        reverse(nums, d, nums.length - 1);
        //reverse the whole array
        reverse(nums, 0, nums.length - 1);
    }

    static void rotateArr(int arr[], int d, int n) {
        d = d % arr.length;
        //reverse the first half
        reverse(arr, 0, d - 1);
        //reverse the second half
        reverse(arr, d, arr.length - 1);
        //reverse the whole array
        reverse(arr, 0, arr.length - 1);
    }

    static void reverse(int[] nums, int l, int r) {
        while (l < r) {
            swap(nums, l, r);
            l++;
            r--;
        }
    }

    static void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
