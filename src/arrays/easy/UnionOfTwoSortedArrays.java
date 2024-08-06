package arrays.easy;

import java.util.ArrayList;

public class UnionOfTwoSortedArrays {
    public static void main(String[] args) {
        int[] arr1 = {-7, 8};
        int[] arr2 = {-8, -3, 8};
        System.out.println(findUnion(arr1, arr2, arr1.length, arr2.length));
    }

    public static ArrayList<Integer> findUnion(int arr1[], int arr2[], int n, int m) {
        int i = 0, j = 0;
        ArrayList<Integer> ans = new ArrayList<>();
        while (i < n && j < m) {
            if (arr1[i] <= arr2[j]) {
                if (ans.isEmpty()) {
                    ans.add(arr1[i]);
                } else if (!ans.get(ans.size() - 1).equals(arr1[i])) {
                    ans.add(arr1[i]);
                }
                i++;
            } else {
                if (ans.isEmpty()) {
                    ans.add(arr2[j]);
                } else if (!ans.get(ans.size() - 1).equals(arr2[j])) {
                    ans.add(arr2[j]);
                }
                j++;
            }
        }
        while (i < n) {
            if (!ans.get(ans.size() - 1).equals(arr1[i]))
                ans.add(arr1[i]);
            i++;
        }
        while (j < m) {
            if (!ans.get(ans.size() - 1).equals(arr2[j]))
                ans.add(arr2[j]);
            j++;
        }
        return ans;
    }
}
