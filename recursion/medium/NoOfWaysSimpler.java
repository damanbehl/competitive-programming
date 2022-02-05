package recursion.medium;

/**
 * https://www.codingninjas.com/codestudio/problems/count-ways-to-reach-nth-stairs_798650
 */
import java.util.Arrays;

public class NoOfWaysSimpler {
    static final int mod = 1000000007;

    public static void main(String[] args) {
        System.out.println(countDistinctWayToClimbStair(485));
    }

    public static int countDistinctWayToClimbStair(long nStairs) {
        return (int) getFibonnacciNumber(nStairs);
    }

    static long getFibonnacciNumber(long nStairs) {
        // [[f(n)][f(n-1)]] == [[1,1][1,0]]^n-1 * [[f(1)] [f(0)]]
        if (nStairs == 0 || nStairs == 1) {
            return 1;
        }
        // System.out.println("going in for power" + (nStairs - 1));
        long[][] base = { { 1, 1 }, { 1, 0 } };
        long[][] toExpect = power(base, nStairs - 1);
        // System.out.println(Arrays.deepToString(toExpect));
        return (toExpect[0][0] % mod + toExpect[0][1] % mod) % mod;
    }

    static long[][] power(long[][] base, long n) {
        // what is 1 in matrices??
        long[][] matrix = { { 1, 0 }, { 0, 1 } };
        while (n > 0) {
            // System.out.println("running for n=" + n);
            if ((n & 1) != 0) {
                matrix = multiply(matrix, base);
            }
            // square even power
            base = multiply(base, base);
            // half
            n = n >> 1;
        }
        // System.out.println("base before returning " + Arrays.deepToString(base));
        // System.out.println("matrix final" + Arrays.deepToString(matrix));
        return matrix;
    }

    static long[][] multiply(long[][] m1, long[][] m2) {
        long[][] R = new long[m1.length][m2[0].length];
        for (int i = 0; i < m1.length; i++) {
            for (int j = 0; j < m2[0].length; j++) {
                for (int k = 0; k < m1[0].length; k++) {
                    R[i][j] = (R[i][j] + (m1[i][k] % mod * m2[k][j] % mod) % mod) % mod;
                }
            }
        }
        return R;
    }
}
