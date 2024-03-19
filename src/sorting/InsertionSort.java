package sorting;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = {7, 6, 5, 8, 9, 1, 10, 4, 33, 5};
        insertionSort(arr, arr.length);
        System.out.println(Arrays.toString(arr));
    }

    public static void insertionSort(int[] arr, int size) {
        for (int i = 1; i < size; i++) {
            int ele = arr[i];
            int j = i;
            while (j > 0 && arr[j - 1] > ele) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = ele;
        }
    }
}
