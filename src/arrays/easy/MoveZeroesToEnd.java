package arrays.easy;

import java.util.Arrays;

public class MoveZeroesToEnd {
    public static void main(String[] args) {
        int[] arr = {0, 1, 0, 3, 12};
        moveZeroes(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void moveZeroes(int[] nums) {
        int l = -1;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] == 0) {
                l = j;
                break;
            }
        }
        if (l == -1)
            return;
        int r = l + 1;
        while (r < nums.length) {
            if (nums[r] != 0) {
                int t = nums[l];
                nums[l] = nums[r];
                nums[r] = t;
                l++;
            }
            r++;
        }
    }
}
