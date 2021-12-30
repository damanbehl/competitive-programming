package SearchingSorting;

import java.lang.annotation.Target;

public class BinarySearch {
    public static void main(String[] args) {
        int arr[] = new int[] { 1, 2, 3, 4 };
        int target = 3;
        System.out.println(binarySearch(arr, target));
    }

    public static int binarySearch(int[] arr, int x) {
        // Your code goes here
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == x) {
                return mid;
            } else if (arr[mid] > x) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }

        }
        return -1;
    }
}
