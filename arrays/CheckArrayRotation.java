package arrays;

public class CheckArrayRotation {
    public static void main(String args[]) {
        int arr[] = { 15, 1, 2, 3, 6, 12 };
        int n = arr.length;

        System.out.println(rotatedArrayCount(arr, n));
    }

    public static int rotatedArray(int arr[], int n) {
        // Write your code here.
        int smallest = Integer.MAX_VALUE;
        int smallestIndex = 0;
        while (n-- > 0) {
            if (arr[n] < smallest) {
                smallest = arr[n];
                smallestIndex = n;
            }
            // if (arr.length > 2 && n > 2 && arr[n - 1] > arr[n]) {
            //     break;
            // }
        }
        return smallest;
    }

    public static int rotatedArrayCount(int arr[], int n) {
        // Write your code here.
        int smallest = Integer.MAX_VALUE;
        int smallestIndex = 0;
        while (n-- > 0) {
            if (arr[n] < smallest) {
                smallest = arr[n];
                smallestIndex = n;
            }
            if (arr.length > 2 && n > 2 && arr[n - 1] > arr[n]) {
                break;
            }
        }
        return smallestIndex;
    }
}
