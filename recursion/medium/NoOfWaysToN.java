package recursion.medium;

import java.util.Arrays;
import java.util.HashMap;

public class NoOfWaysToN {
    static final int mod = 1000000007;
    static long[][][] exponents;

    public static void main(String[] args) {
        // System.out.println(countNumberOfWays(30));
        System.out.println(countDistinctWayToClimbStair(2147483647));
    }

    public static int countDistinctWayToClimbStair(long nStairs) {
        if (nStairs == 0 || nStairs == 1) {
            return 1;
        }
        // Write your code here.
        return (int) getFibNumber(nStairs - 1);
    }

    static long getFibNumber(long nstairs) {
        int maxActiveBit = 0;
        for (int i = 31; i >= 0; i--) {
            if ((nstairs & (1 << i)) != 0) {
                maxActiveBit = i;
                break;
            }
        }
        populateExponents(maxActiveBit);
        final long[][] resMat = exponentiate(nstairs, maxActiveBit);

        return (resMat[0][0] % mod + resMat[0][1] % mod) % mod;
    }

    static void populateExponents(int n) {
        exponents = new long[n + 1][2][2];
        exponents[0] = new long[][] { { 1, 1 }, { 1, 0 } };
        for (int i = 1; i <= n; i++) {
            exponents[i] = square(exponents[i - 1]);
        }
    }

    static long[][] exponentiate(long n, int maxActiveBit) {
        long result[][] = { { 1, 0 }, { 0, 1 } };
        for (int i = maxActiveBit; i >= 0; i--) {
            if ((n & (1 << i)) != 0) {
                result = multiply(result, exponents[i]);
            }
        }
        return result;
    }

    static long[][] square(long[][] matrix) {
        return multiply(matrix, matrix);
    }

    static long[][] multiply(long m1[][], long m2[][]) {
        int m1Rows = m1.length;
        int m1Cols = m1[0].length;
        int m2Rows = m2.length;
        int m2Cols = m2[0].length;
        long R[][] = new long[m1Rows][m2Cols];
        for (int i = 0; i < m1Rows; i++) {
            for (int j = 0; j < m2Cols; j++) {
                for (int k = 0; k < m1Cols; k++) {
                    R[i][j] = (R[i][j] % mod + (m1[i][k] % mod * m2[k][j] % mod) % mod) % mod;
                }
            }
        }
        return R;
    }

    static int countNumberOfWays(int x) {
        if (x == 0) {
            return 1;
        }
        if (x < 0) {
            return 0;
        }
        return countNumberOfWays(x - 3) + countNumberOfWays(x - 2) + countNumberOfWays(x - 1);
    }

    // using fibonacci but this will be O(N)
    public static int countDistinctWayToClimbStairIterative(long nStairs) {
        int a = 1;
        int b = 1;
        nStairs = nStairs % mod;
        for (int i = 2; i <= nStairs; i++) {
            int temp = b;
            b = (a % mod + b % mod) % mod;
            a = temp;

        }
        return b;
    }

    // Will take too much space
    public static int countDistinctWayToClimbStairCache(long nStairs, HashMap<Long, Integer> hm) {
        // Write your code here.
        if (nStairs == 0) {
            return 1;
        }
        if (nStairs < 0) {
            return 0;
        }
        if (hm.getOrDefault(nStairs, 0) != 0) {
            return hm.get(nStairs);
        }
        int nMinusTwo = countDistinctWayToClimbStairCache(nStairs - 2, hm) % mod;
        int nMinusOne = countDistinctWayToClimbStairCache(nStairs - 1, hm) % mod;
        int res = (nMinusOne + nMinusTwo) % mod;
        hm.put(nStairs, res);
        return res;
    }
}
