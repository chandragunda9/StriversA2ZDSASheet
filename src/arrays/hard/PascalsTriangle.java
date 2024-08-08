package arrays.hard;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {

    public static void main(String[] args) {
        int n = 5;
        System.out.println(generate(n));
        int nthRow = 144;
        System.out.println(nthRowOfPascalTriangle(nthRow));
    }

    public static List<Integer> generateNthRow(int row) {
        List<Integer> rowValues = new ArrayList<>();
        rowValues.add(1);
        int mul = 1;
        for (int col = 1; col < row; col++) {
            mul = mul * (row - col);
            mul = mul / col;
            rowValues.add(mul);
        }
        return rowValues;
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        for (int row = 1; row <= numRows; row++) {
            ans.add(generateNthRow(row));
        }
        return ans;
    }

    static ArrayList<Long> nthRowOfPascalTriangle(int row) {
        int mod = (int) (1e9 + 7);
        ArrayList<Long> ans = new ArrayList<>();
        ans.add(1L);
        long mul = 1;
        for (int col = 1; col < row; col++) {
            mul = mul * (row - col) % mod;
            mul = mul * modInverse(col, mod) % mod;
            ans.add(mul);
        }
        return ans;
    }

    static long modInverse(long a, int mod) {
        return power(a, mod - 2, mod);
    }

    static long power(long x, long y, int mod) {
        x = x % mod;
        long res = 1;
        while (y > 0) {
            if ((y & 1) == 1) {
                res = (res * x) % mod;
            }
            y >>= 1;
            x = (x * x) % mod;
        }
        return res;
    }
}
