package arrays.easy;

import java.util.Arrays;
import java.util.List;

public class SecondLargestElementInArray {
    public static void main(String[] args) {
        Integer[] arr = {10, 5, 10};
        System.out.println(print2largest(Arrays.asList(arr)));
    }

    public static int print2largest(List<Integer> arr) {
        int largest = Integer.MIN_VALUE, sLargest = Integer.MIN_VALUE;
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i) > largest) {
                sLargest = largest;
                largest = arr.get(i);
            } else if (arr.get(i) < largest && arr.get(i) > sLargest) {
                sLargest = arr.get(i);
            }
        }
        return sLargest;
    }
}
