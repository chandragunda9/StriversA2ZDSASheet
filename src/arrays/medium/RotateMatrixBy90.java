package arrays.medium;

import java.util.Arrays;

public class RotateMatrixBy90 {
    public static void main(String[] args) {
        int[][] mat = {{5, 1, 9, 11}, {2, 4, 8, 10}, {13, 3, 6, 7}, {15, 14, 12, 16}};
        rotate(mat);
        System.out.println(Arrays.deepToString(mat));
    }

    public static void rotate(int[][] matrix) {
        //rotating matrix by 90 clockwise involves transposing and then reversing each array
        //Transposing the matrix
        int n = matrix.length, m = matrix[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < m; j++) {
                int t = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = t;
            }
        }

        //reversing each array
        for (int i = 0; i < n; i++) {
            reverse(matrix[i], 0, m - 1);
        }
    }

    static void reverse(int[] arr, int l, int r) {
        while (l < r) {
            swap(arr, l, r);
            l++;
            r--;
        }
    }

    static void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    static void rotateby90AntiClockWise(int matrix[][], int n) {
        //rotating matrix by 90 clockwise involves transposing and then reversing each array
        //Transposing the matrix
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int t = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = t;
            }
        }

        //reversing each column
        for (int j = 0; j < n; j++) {
            int start = 0, end = n - 1;
            while (start < end) {
                int t = matrix[start][j];
                matrix[start][j] = matrix[end][j];
                matrix[end][j] = t;
                start++;
                end--;
            }
        }
    }
}
