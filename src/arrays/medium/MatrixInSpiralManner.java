package arrays.medium;

import java.util.ArrayList;
import java.util.List;

public class MatrixInSpiralManner {
    public static void main(String[] args) {
        int[][] mat = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(spiralOrder(mat));
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        ArrayList<Integer> ans = new ArrayList<>();
        int top = 0, down = n - 1, left = 0, right = m - 1;
        int dir = 0;
        while (top <= down && left <= right) {
            if (dir == 0) {
                for (int i = left; i <= right; i++) {
                    ans.add(matrix[top][i]);
                }
                top++;
            } else if (dir == 1) {
                for (int i = top; i <= down; i++) {
                    ans.add(matrix[i][right]);
                }
                right--;
            } else if (dir == 2) {
                for (int i = right; i >= left; i--) {
                    ans.add(matrix[down][i]);
                }
                down--;
            } else {
                for (int i = down; i >= top; i--) {
                    ans.add(matrix[i][left]);
                }
                left++;
            }
            dir = (dir + 1) % 4;
        }
        return ans;
    }
}
