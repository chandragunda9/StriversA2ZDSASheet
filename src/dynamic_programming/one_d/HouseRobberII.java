package dynamic_programming.one_d;

import java.util.ArrayList;

public class HouseRobberII {
    public static void main(String[] args) {
        int[] val = {1, 3, 2, 1};
        System.out.println(houseRobber(val));
    }

    public static long houseRobber(int[] valueInHouse) {
        if (valueInHouse.length == 1)
            return valueInHouse[0];
        if (valueInHouse.length == 2)
            return Math.max(valueInHouse[0], valueInHouse[1]);
        long ans1 = tab(valueInHouse, 0, valueInHouse.length - 2);
        long ans2 = tab(valueInHouse, 1, valueInHouse.length - 1);
        return Math.max(ans1, ans2);
    }

    static long tab(int[] nums, int i, int j) {
        //storing maxsums upto that index
        long prev2 = nums[i];
        long prev = Math.max(nums[i], nums[i + 1]);
        for (int k = i + 2; k <= j; k++) {
            long take = nums[k] + prev2;
            long notTake = prev;  //0+prev
            long curr = Math.max(take, notTake);
            prev2 = prev;
            prev = curr;
        }
        return prev;
    }
}
