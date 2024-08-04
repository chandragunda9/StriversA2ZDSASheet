package arrays.medium;

import java.util.ArrayList;

public class ArrayLeaders {
    static ArrayList<Integer> leaders(int n, int arr[]) {
        int rightMax = Integer.MIN_VALUE;
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = n - 1; i >= 0; i--) {
            if (arr[i] >= rightMax) {
                ans.add(0, arr[i]);
                rightMax = arr[i];
            }
        }
        return ans;
    }
}
