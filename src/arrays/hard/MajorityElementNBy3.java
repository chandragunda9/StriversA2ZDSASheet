package arrays.hard;

import java.util.ArrayList;
import java.util.List;

public class MajorityElementNBy3 {
    public static void main(String[] args) {
        int[] arr = {3, 2, 3};
        System.out.println(majorityElement(arr));
    }

    public static List<Integer> majorityElement(int[] nums) {
        int count1 = 0, count2 = 0, ele1 = Integer.MIN_VALUE, ele2 = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int val = nums[i];
            if (count1 == 0 && val != ele2) {
                count1 = 1;
                ele1 = val;
            } else if (count2 == 0 && val != ele1) {
                count2 = 1;
                ele2 = val;
            } else if (ele1 == val) {
                count1++;
            } else if (ele2 == val) {
                count2++;
            } else {
                count1--;
                count2--;
            }
        }
        List<Integer> ans = new ArrayList<>();
        count1 = 0;
        count2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == ele1)
                count1++;
            else if (nums[i] == ele2) {
                count2++;
            }
        }
        if (count1 > nums.length / 3)
            ans.add(ele1);
        if (count2 > nums.length / 3)
            ans.add(ele2);
        return ans;
    }
}
