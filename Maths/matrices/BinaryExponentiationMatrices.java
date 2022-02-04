package Maths.matrices;

class Main {
    public static void main(String[] args) {
        final BinaryExponentiationMatrices bm = new BinaryExponentiationMatrices();
        System.out.println(BinaryExponentiationMatrices.getFibonacciNumber(0));
    }
}

class BinaryExponentiationMatrices {
    static long exponents[][][];

    public BinaryExponentiationMatrices() {
        exponents = new long[64][2][2];
        exponents[0] = new long[][] { { 1, 1 }, { 1, 0 } };
        for (int i = 1; i < exponents.length; i++) {
            exponents[i] = square(exponents[i - 1]);
        }
    }

    static long[][] square(long[][] m1) {
        return multiply(m1, m1);
    }

    static long[][] multiply(long[][] m1, long m2[][]) throws IllegalArgumentException {
        int m1Rows = m1.length, m1Cols = m1[0].length;
        int m2Rows = m2.length, m2Cols = m2[0].length;
        if (m1Cols != m2Rows) {
            throw new IllegalArgumentException();
        }
        long R[][] = new long[m1Rows][m2Cols];
        for (int i = 0; i < m1Rows; i++) {
            for (int j = 0; j < m2Cols; j++) {
                for (int k = 0; k < m2Rows; k++) {
                    R[i][j] += m1[i][k] * m2[k][j];
                }
            }
        }
        return R;
    }

    static long getFibonacciNumber(int n) {
        if (n < 0) {
            throw new IllegalArgumentException();
        }
        if (n == 0 || n == 1) {
            return 1;
        }
        final long[][] resultantMatrix = exponentiate(n - 1);
        return resultantMatrix[0][0] + resultantMatrix[0][1];
    }

    static long[][] exponentiate(final int exponent) {
        long result[][] = { { 1, 0 }, { 0, 1 } };
        for (int i = 31; i >= 0; i--) {
            if ((exponent & (1 << i)) != 0) {
                result = multiply(result, exponents[i]);
            }
        }
        return result;
    }

}