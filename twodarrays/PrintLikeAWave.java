package twodarrays;

import java.util.Arrays;
/**
 * level easy
 * https://www.codingninjas.com/codestudio/problems/print-like-a-wave_893268
 */
import java.util.Scanner;

public class PrintLikeAWave {
    static Scanner sc;

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int row = sc.nextInt();
            int cols = sc.nextInt();
            int arr[][] = inputArray(row, cols);
            System.out.println(Arrays.toString(wavePrint(arr, row, cols)));
        }
        // int rows = 5;
        // int cols = 3;
        // int arr[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 }, { 10, 11, 12 }, { 13,
        // 14, 15 } };
        // System.out.println(Arrays.toString(wavePrint(arr, rows, cols)));
    }

    public static int[] wavePrint(int arr[][], int nRows, int mCols) {
        // Write your code here.
        int result[] = new int[nRows * mCols];
        int resIter = 0;
        for (int i = 0; i < mCols; i++) {
            if (i % 2 == 0) {
                for (int j = 0; j < nRows; j++) {
                    result[resIter] = arr[j][i];
                    resIter++;
                }
            } else {
                for (int j = nRows - 1; j >= 0; j--) {
                    result[resIter] = arr[j][i];
                    resIter++;
                }
            }
        }
        return result;
    }

    static int[][] inputArray(int rows, int columns) {
        int array[][] = new int[rows][columns];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                array[i][j] = sc.nextInt();
            }
        }
        return array;
    }
}
