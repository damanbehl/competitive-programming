package Maths.matrices;

public class MultiplyMatrices {
    public static void main(String[] args) {
        int input[][] = { { 1, 1, 1 }, { 1, 1, 1 } };
        int input2[][] = { { 1, 1 }, { 1, 1 }, { 1, 1 } };
        printMatrix(multiply(input, input2));
    }

    static int[][] multiply(int[][] m1, int m2[][]) throws IllegalArgumentException {
        int m1Rows = m1.length, m1Cols = m1[0].length;
        int m2Rows = m2.length, m2Cols = m2[0].length;
        if (m1Cols != m2Rows) {
            throw new IllegalArgumentException();
        }
        int R[][] = new int[m1Rows][m2Cols];
        for (int i = 0; i < m1Rows; i++) {
            for (int j = 0; j < m2Cols; j++) {
                for (int k = 0; k < m2Rows; k++) {
                    R[i][j] += m1[i][k] * m2[k][j];
                }
            }
        }
        return R;
    }

    static void printMatrix(int[][] matrixA) {
        for (int i = 0; i < matrixA.length; i++) {
            for (int j = 0; j < matrixA[0].length; j++) {
                System.out.print(matrixA[i][j] + " ");
            }
            System.out.println();
        }
    }
}
