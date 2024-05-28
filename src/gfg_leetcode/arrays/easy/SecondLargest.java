package gfg_leetcode.arrays.easy;

public class SecondLargest {
    public static void main(String[] args) {
        int[] arr = {10, 5, 10};
        System.out.println(print2largest(arr, arr.length));
    }

    static int print2largest(int arr[], int n) {
        int largest = Integer.MIN_VALUE;
        int sLargest = Integer.MIN_VALUE;
        for (int ele : arr) {
            if (ele > largest) {
                sLargest = largest;
                largest = ele;
            } else if (ele > sLargest && ele < largest) {
                sLargest = ele;
            }
        }
        return sLargest != Integer.MIN_VALUE ? sLargest : -1;
    }
}
