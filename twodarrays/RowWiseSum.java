package twodarrays;

import java.util.Arrays;
import java.util.Scanner;

public class RowWiseSum {
    static Scanner sc;

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int rows = sc.nextInt();
            int cols = sc.nextInt();
            int array[][] = inputArray(rows, cols);
            // for (int x : returnRowSum(array)) {
            // System.out.print(x + " ");
            // System.out.println();
            // }
            System.out.println(Arrays.toString(returnMaxColumnSum(array)));
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

    static int[] returnRowSum(int array[][]) {
        int rowSum[] = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            int sum = 0;
            for (int x : array[i]) {
                sum = sum + x;
            }
            rowSum[i] = sum;
        }
        return rowSum;
    }

    static int[] returnMaxColumnSum(int array[][]) {
        int max = Integer.MIN_VALUE;
        int resultantColumn = 0;
        for (int i = 0; i < array.length; i++) {
            int sum = 0;
            for (int j = 0; j < array[0].length; j++) {
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
}
