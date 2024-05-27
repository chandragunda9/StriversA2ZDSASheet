package sorting;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {5, 4, 3, 2, 1, 0};
        selectionSort(arr, arr.length);
        System.out.println(Arrays.toString(arr));
    }

    static int select(int arr[], int i) {
        // code here such that selectionSort() sorts arr[]
        int minInd = i;
        for (int j = i + 1; j < arr.length; j++) {
            if (arr[j] < arr[minInd])
                minInd = j;
        }
        return minInd;
    }

    static void selectionSort(int arr[], int n) {
        for (int i = 0; i < n - 1; i++) {
            int minInd = select(arr, i);
            //swap
            int t = arr[i];
            arr[i] = arr[minInd];
            arr[minInd] = t;
        }
    }
}
