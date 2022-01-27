/**
 * https://www.codingninjas.com/codestudio/problems/recursive-multiply_1172216
 */
package recursion.low_medium;

import java.util.HashMap;

public class MultiplyRecursive {
    static int mod = 1000000007;

    public static void main(String[] args) {
        System.out.println(recursiveProduct(92299999, 99999999));
        // System.out.println(recursiveProduct(50, 10));
    }

    public static int recursiveProduct(int m, int n) {
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        if (m >= n) {
            return helperFunc(m, n, hm);
        } else {
            return helperFunc(n, m, hm);
        }
    }

    static int helperFunc(int m, int n, HashMap<Integer, Integer> hm) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return m;
        }
        int halfN = n >> 1;
        if ((n & 1) != 0) {
            int forHalfN;
            if (hm.getOrDefault(halfN, 0) != 0) {
                forHalfN = hm.get(halfN);
            } else {
                forHalfN = helperFunc(m, halfN, hm) % mod;
                hm.put(halfN, forHalfN);
            }
            int forRem;
            if (hm.getOrDefault(n - halfN, 0) != 0) {
                forRem = hm.get(n - halfN);
            } else {
                forRem = helperFunc(m, n - halfN, hm) % mod;
                hm.put(n - halfN, forRem);
            }
            return (forHalfN % mod + forRem % mod) % mod;
        } else {
            if (hm.getOrDefault(halfN, 0) != 0) {
                return (2 * hm.get(halfN)) % mod;
            } else {
                int forHalfN = helperFunc(m, halfN, hm) % mod;
                hm.put(halfN, forHalfN);
                return (2 * forHalfN) % mod;

            }

        }

    }
}