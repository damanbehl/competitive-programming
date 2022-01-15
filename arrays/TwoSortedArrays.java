//https://www.codingninjas.com/codestudio/problems/ninja-and-sorted-arrays_1214628
//without extra space
package arrays;

import java.util.Arrays;

public class TwoSortedArrays {
    public static void main(String[] args) {
        int arr1[] = { 1, 2, 4, 10, 20, 30, 0 };
        int arr2[] = { 5 };
        System.out.println(Arrays.toString(ninjaAndSortedArrays(arr1, arr2, 6, arr2.length)));
    }

    public static int[] ninjaAndSortedArrays(int arr1[], int arr2[], int m, int n) {
        // Write your code here.
        int totalElements = m + n;
        int i = 0;
        // int j = 0;
        while (i < m) {
            if (arr1[i] <= arr2[0]) {
                i++;
            } else {
                int temp = arr1[i];
                arr1[i] = arr2[0];
                for (int iter = 0; iter < n; iter++) {
                    if (iter == 0) {
                        arr2[0] = temp;
                        continue;
                    }
                    if (arr2[iter] > arr2[iter - 1]) {
                        break;
                    }
                    int swap = arr2[iter - 1];
                    arr2[iter - 1] = arr2[iter];
                    arr2[iter] = swap;
                }
            }
        }
        // System.out.println("arr1>" + Arrays.toString(arr1));
        // System.out.println("arr2> " + Arrays.toString(arr2));
        int j = 0;
        while (i < totalElements) {
            arr1[i] = arr2[j];
            j++;
            i++;
        }
        return arr1;
    }

    // public static int[] ninjaAndSortedArrays(int arr1[], int arr2[], int m, int
    // n) {
    // // Write your code here.
    // int totalElements = m + n;
    // int i = 0;
    // // int j = 0;
    // while (i < m) {
    // if (arr1[i] <= arr2[0]) {
    // i++;
    // } else {
    // int temp = arr1[i];
    // arr1[i] = arr2[0];
    // for (int iter = 0; iter < n; iter++) {
    // if (iter == 0) {
    // arr2[0] = temp;
    // continue;
    // }
    // if (arr2[iter] > temp) {
    // arr2[iter - 1] = temp;
    // break;
    // }
    // arr2[iter - 1] = arr2[iter];
    // arr2[iter] = temp;
    // }
    // }
    // }
    // // System.out.println("arr1>" + Arrays.toString(arr1));
    // // System.out.println("arr2> " + Arrays.toString(arr2));
    // int j = 0;
    // while (i < totalElements) {
    // arr1[i] = arr2[j];
    // j++;
    // i++;
    // }
    // return arr1;
    // }

    // public static int[] ninjaAndSortedArrays(int arr1[], int arr2[], int m, int
    // n) {
    // int arr3[] = new int[m + n];
    // int k = 0;
    // int i = 0, j = 0;
    // while (i < m && j < n) {
    // if (arr1[i] <= arr2[j]) {
    // arr3[k] = arr1[i];
    // i++;
    // } else {
    // arr3[k] = arr2[j];
    // j++;
    // }
    // k++;
    // }
    // while (i < m) {
    // arr3[k] = arr1[i];
    // i++;
    // k++;
    // }
    // while (j < n) {
    // arr3[k] = arr2[j];
    // k++;
    // j++;
    // }
    // return arr3;
    // }
}
