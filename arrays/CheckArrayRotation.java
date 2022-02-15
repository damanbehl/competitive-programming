package arrays;

public class CheckArrayRotation {
    public static void main(String args[]) {
        int arr[] = { 10, 20, 30, 1 };
        int n = arr.length;
        CheckArrayRotation ob = new CheckArrayRotation();
        System.out.println(ob.findKRotation(arr, n));
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
            // break;
            // }
        }
        return smallest;
    }

    // simpler
    public static int rotatedArraySimpler(int arr[], int n) {
        int returnVal = arr[0];
        for (int i = 0; i < n - 1; i++) {
            if (arr[i + 1] < arr[i]) {
                returnVal = arr[i + 1];
                break;
            }
        }
        return returnVal;
    }

    // inefficient
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

    // better
    int findKRotation(int arr[], int n) {
        int result = 0;
        for (int i = 0; i < n - 1; i++) {
            if (arr[i + 1] < arr[i]) {
                result = i + 1;
                break;
            }
        }
        return result;
    }
}
