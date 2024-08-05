package arrays.easy;

import java.util.List;

public class RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        int[] arr = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println(removeDuplicates(arr));
    }

    public static int removeDuplicates(int[] nums) {
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[i] != nums[j]) {
                nums[++i] = nums[j];
            }
        }
        return i + 1;
    }

    public int remove_duplicate(List<Integer> nums) {
        int i = 0;
        for (int j = 1; j < nums.size(); j++) {
            if (!nums.get(i).equals(nums.get(j))) {
                nums.set(++i, nums.get(j));
            }
        }
        return i + 1;
    }
}
