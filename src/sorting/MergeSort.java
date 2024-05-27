package sorting;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {5, 4, 3, 2, 1};
        mergeSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    static void merge(int arr[], int l, int m, int r) {
        int n1 = m - l + 1, n2 = r - m;
        int[] lhalf = new int[n1], rhalf = new int[n2];
        for (int i = 0; i < n1; i++) {
            lhalf[i] = arr[l + i];
        }
        for (int i = 0; i < n2; i++) {
            rhalf[i] = arr[m + 1 + i];
        }
        int i = 0, j = 0, k = l;
        while (i < n1 && j < n2) {
            if (lhalf[i] <= rhalf[j]) {
                arr[k++] = lhalf[i++];
            } else {
                arr[k++] = rhalf[j++];
            }
        }
        while (i < n1) {
            arr[k++] = lhalf[i++];
        }
        while (j < n2) {
            arr[k++] = rhalf[j++];
        }
    }

    static void mergeSort(int arr[], int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;
            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);
            merge(arr, l, m, r);
        }
    }
}
