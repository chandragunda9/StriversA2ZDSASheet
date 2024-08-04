package arrays.medium;

import java.util.Arrays;

public class SortAnArray0s1s2s {
    public static void main(String[] args) {
        int[] arr = {0, 2, 1, 2, 0};
        sort012(arr, arr.length);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort012(int a[], int n) {
        int low = 0, mid = 0, high = n - 1;
        while (mid <= high) {
            if (a[mid] == 0) {
                swap(a, low, mid);
                low++;
                mid++;
            } else if (a[mid] == 1) {
                mid++;
            } else {
                swap(a, mid, high);
                high--;
            }
        }
    }

    static void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}
