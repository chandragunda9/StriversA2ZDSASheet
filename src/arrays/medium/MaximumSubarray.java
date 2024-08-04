package arrays.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaximumSubarray {
    public static void main(String[] args) {
        int[] arr = {2, 4, -4, 1, 2, 3};
        System.out.println(findSubarray(arr.length, arr));
    }

    static ArrayList<Integer> findSubarray(int n, int a[]) {
        int sum = 0, maxSum = Integer.MIN_VALUE, gStartInd = -1, gEndInd = -1, startInd = -1;
        for (int i = 0; i < n; i++) {
            if (a[i] < 0) {
                sum = 0;
                continue;
            }
            if (sum == 0) {
                startInd = i;
            }
            sum += a[i];
            if (sum >= maxSum) {
                if (sum == maxSum) {
                    if (i - startInd + 1 > gEndInd - gStartInd + 1) {
                        gStartInd = startInd;
                        gEndInd = i;
                    }
                } else {
                    gStartInd = startInd;
                    gEndInd = i;
                }
                maxSum = sum;
            }
        }
        if (gStartInd == -1)
            return new ArrayList<>(List.of(-1));
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = gStartInd; i <= gEndInd; i++) {
            ans.add(a[i]);
        }
        return ans;
    }
}
