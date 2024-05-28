package gfg_leetcode.arrays.easy;

public class LargestElement {
    public int largest(int arr[], int n) {
        int max = Integer.MIN_VALUE;
        for (int ele : arr) {
            if (ele > max)
                max = ele;
        }
        return max;
    }
}
