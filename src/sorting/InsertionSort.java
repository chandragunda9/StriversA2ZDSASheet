package sorting;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = {5, 4, 3, 2, 1};
        insertionSort(arr, arr.length);
        System.out.println(Arrays.toString(arr));
    }

    static void insert(int arr[], int i) {
        int j = i;
        int ele = arr[i];
        while (j > 0 && arr[j - 1] > ele) {
            arr[j] = arr[j - 1];
            j = j - 1;
        }
        arr[j] = ele;
    }

    //Function to sort the array using insertion sort algorithm.
    public static void insertionSort(int arr[], int n) {
        for (int i = 1; i < n; i++) {
            insert(arr, i);
        }
    }
}
