package twodarrays;

/**
 * https://leetcode.com/problems/spiral-matrix/
 * https://www.codingninjas.com/codestudio/problems/print-spiral_547
 */
import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public static void main(String[] args) {
        int matrix[][] = { { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 },
                { 13, 14, 15, 16 } };
        int smatrix[][] = {};
        print(spiralOrder(smatrix));

    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix.length == 0) {
            return result;
        }
        result = printMatrix(matrix, 0, matrix.length - 1, 0, matrix[0].length - 1, result);
        return result;
    }

    public static List<Integer> printMatrix(int[][] matrix, int k, int l, int m, int n, List<Integer> result) {
        if (k < l && m < n) {

            // top row
            for (int col = m; col <= n; col++) {
                result.add(matrix[k][col]);
            }
            k++;
            // right col
            for (int rw = k; rw <= l; rw++) {
                result.add(matrix[rw][n]);
            }
            n--;
            // bottom row
            for (int col = n; col >= m; col--) {
                result.add(matrix[l][col]);
            }
            l--;
            // left col
            for (int rw = l; rw >= k; rw--) {
                result.add(matrix[rw][m]);
            }
            m++;
            return printMatrix(matrix, k, l, m, n, result);
        }
        // For remaining single inner row or column
        if (k == l) {
            for (int col = m; col <= n; col++) {
                result.add(matrix[k][col]);
            }
            k++;
        }
        if (m == n) {
            for (int rw = k; rw <= l; rw++) {
                result.add(matrix[rw][n]);
            }
            n--;
        }
        return result;

    }

    public static void spiralPrint(int matrix[][]) {
        // Your code goes here

    }

    static void print(List<Integer> al) {
        for (int x : al) {
            System.out.print(x + " ");
        }
    }
}
