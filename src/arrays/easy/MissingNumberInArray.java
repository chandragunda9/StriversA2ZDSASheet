package arrays.easy;

public class MissingNumberInArray {
    public static void main(String[] args) {
        int[] nums = {9, 6, 4, 2, 3, 5, 7, 0, 1};
        System.out.println(missingNumber(nums));
    }

    public static int missingNumber(int[] nums) {
        int xor = 0;
        for (int ele : nums) {
            xor ^= ele;
        }
        for (int i = 0; i <= nums.length; i++) {
            xor ^= i;
        }
        return xor;
    }
}
