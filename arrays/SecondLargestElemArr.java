package arrays;

public class SecondLargestElemArr {
    public static void main(String[] args) {
        int n = 6;
        // int arr[] = new int[] { 7, 8, 8, 1, 4, 3 };
        int arr[] = new int[] { 9, 9, 9, 9, 9, 9 };
        System.out.println(findSecondLargest(arr.length, arr));
    }

    public static int findSecondLargest(int n, int[] arr) {
        // Write your code here.
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (arr[i] > largest) {
                secondLargest = largest;
                largest = arr[i];
            } else if (arr[i] > secondLargest && arr[i] < largest) {
                secondLargest = arr[i];
            }

        }
        if (largest == secondLargest || secondLargest == Integer.MIN_VALUE) {
            return -1;
        }
        return secondLargest;
    }
}
