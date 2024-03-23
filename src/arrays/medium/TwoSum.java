package arrays.medium;

import java.util.HashSet;

public class TwoSum {
    public static void main(String[] args) {
        int[] books = {4, 1, 2, 3, 1};
        int n = 5, target = 5;
        System.out.println(read(n, books, target));
    }

    public static String read(int n, int[] book, int target) {
        HashSet<Integer> has = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if (has.contains(target - book[i])) {
                return "YES";
            } else
                has.add(book[i]);
        }
        return "NO";
    }
}
