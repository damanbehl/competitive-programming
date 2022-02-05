package recursion.medium;

import java.util.HashMap;

public class StaircaseProblemBase {
    static final int mod = 1000000007;

    public static void main(String[] args) {
        System.out.println(numberOfWays(8, new int[] { 1, 3, 5 }));
    }

    // generic solution but for int
    // bottom up DP
    static int numberOfWays(int n, int[] allowedSteps) {
        if (n == 0) {
            return 1;
        }
        int nums[] = new int[n + 1];
        nums[0] = 1;
        for (int i = 1; i <= n; i++) {
            int sum = 0;
            for (int x : allowedSteps) {
                if (i - x >= 0) {
                    sum += nums[i - x];
                }
            }
            nums[i] = sum;
        }
        return nums[n];
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
