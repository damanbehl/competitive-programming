package arrays.easy;

//https://leetcode.com/problems/reshape-the-matrix
public class ReshapeMatrix {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int orow = mat.length;
        int ocol = mat[0].length;
        if ((r == orow && c == ocol) || r * c > orow * ocol || r * c < orow * ocol) {
            return mat;
        }
        int newArr[][] = new int[r][c];
        int row = 0;
        int col = 0;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (col == c) {
                    col = 0;
                    row++;
                }
                newArr[row][col] = mat[i][j];
                col++;
            }
        }
        return newArr;
    }
}
