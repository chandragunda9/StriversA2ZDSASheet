package arrays.easy;

public class BinarySearch {
    static int searchInSorted(int arr[], int N, int K) {
        int l = 0, r = N - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (arr[mid] == K)
                return 1;
            else if (K > arr[mid]) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return -1;
    }
}
