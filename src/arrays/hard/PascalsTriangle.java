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

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> temp = new ArrayList<>();
            temp.add(1);
            int mul = 1;
            for (int j = 0; j < i; j++) {
                mul = mul * (i - j) / (j + 1);
                temp.add(mul);
            }
            ans.add(temp);
        }
        return ans;
    }

    static ArrayList<Long> nthRowOfPascalTriangle(int n) {
        int mod = (int) (1e9 + 7);
        ArrayList<Long> ans = new ArrayList<>();
        ans.add(1L);
        long mul = 1;
        int rowInd = n - 1;
        for (int j = 0; j < rowInd; j++) {
//            mul = mul * (rowInd - j) / (j + 1);
            mul = mul * (rowInd - j) % mod * modInverse(j + 1, mod) % mod;
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
