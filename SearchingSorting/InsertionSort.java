package SearchingSorting;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int input[] = new int[] { 5, 4, 3, 2, 1 };
        int n = input.length;
        insertionSort(n, input);
        System.out.println(Arrays.toString(input));
    }

    public static void insertionSort(int n, int[] arr) {
        // Write your code here.
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;
            for (; j >= 0 && arr[j] > key; j--) {
                arr[j + 1] = arr[j];
            }
            arr[j + 1] = key;
        }
    }
}
