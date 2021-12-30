package SearchingSorting;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        // int arrayToSort[] = { 4, 6, 2, 5, 7, 9, 1, 3 };
        int arrayToSort[] = { 2, 2 };
        sortQuick(arrayToSort, 0, arrayToSort.length - 1);
        System.out.println(Arrays.toString(arrayToSort));
    }

    static void sortQuick(int arr[], int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            sortQuick(arr, low, pi - 1);
            sortQuick(arr, pi + 1, high);
        }
    }

    static int partition(int arr[], int low, int high) {
        int pivot = arr[low];
        int i = low;
        int j = high;
        for (; i < j;) {
            for (; arr[i] <= pivot && i < high; i++)
                ;
            for (; arr[j] > pivot && j >= 0; j--)
                ;
            if (i < j) {
                // System.out.println(" at swap i " + i + " at swap j = " + j + " \tfor " +
                // Arrays.toString(arr));
                swap(arr, i, j);
            }
        }
        swap(arr, low, j);
        return j;
    }

    static void swap(int arr[], int x1, int x2) {
        int temp = arr[x1];
        arr[x1] = arr[x2];
        arr[x2] = temp;
    }
}
