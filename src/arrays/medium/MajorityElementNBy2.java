package arrays.medium;

public class MajorityElementNBy2 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        System.out.println(majorityElement(arr, arr.length));
    }

    static int majorityElement(int a[], int size) {
        //By using moore's voting algorithm
        int count = 0, ele = -1;
        for (int i = 0; i < size; i++) {
            if (count == 0) {
                ele = a[i];
                count = 1;
            } else if (ele == a[i]) {
                count++;
            } else {
                count--;
            }
        }
        count = 0;
        for (int i = 0; i < size; i++) {
            if (a[i] == ele)
                count++;
        }
        return count > size / 2 ? ele : -1;
    }
}
