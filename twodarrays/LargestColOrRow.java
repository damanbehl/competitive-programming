package twodarrays;

/**
 * difficulty easy
 */

import java.util.Scanner;

public class LargestColOrRow {
    static Scanner sc;

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int row = sc.nextInt();
            int cols = sc.nextInt();
            int arr[][] = inputArray(row, cols);
            int[] maxRow = returnMaxRowSum(arr);
            int[] maxColumn = returnMaxColumnSum(arr);
            if (maxRow[1] >= maxColumn[1]) {
                System.out.println("row " + maxRow[0] + " " + maxRow[1]);
            } else {
                System.out.println("column " + maxColumn[0] + " " + maxColumn[1]);
            }
        }
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

    static int[] returnMaxColumnSum(int array[][]) {
        int max = Integer.MIN_VALUE;
        int resultantColumn = 0;
        for (int i = 0; i < array[0].length; i++) {
            int sum = 0;
            for (int j = 0; j < array.length; j++) {
                sum = sum + array[j][i];
            }
            if (sum > max) {
                max = sum;
                resultantColumn = i;
            }
        }
        int returnVal[] = { resultantColumn, max };
        return returnVal;
    }

    static int[] returnMaxRowSum(int array[][]) {
        int max = Integer.MIN_VALUE;
        int resultantRow = 0;
        for (int i = 0; i < array.length; i++) {
            int sum = 0;
            for (int j = 0; j < array[0].length; j++) {
                sum = sum + array[i][j];
            }
            if (sum > max) {
                max = sum;
                resultantRow = i;
            }
        }
        int returnVal[] = { resultantRow, max };
        return returnVal;
    }
}
