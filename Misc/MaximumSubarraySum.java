package misc;

/**
 * https://leetcode.com/problems/maximum-subarray/
 */
import java.util.ArrayList;
// import java.util.Arrays;
// import java.util.Collection;
// import java.util.Collections;

public class MaximumSubarraySum {
    public static void main(String[] args) {
        int inp[] = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
        System.out.println(maxSubArray(inp));
    }

    public static long maxSubarraySum(int[] arr, int n) {
        // write your code here
        long sum = 0;
        long bestUpToNow = 0;
        for (int i = 0; i < n; i++) {
            bestUpToNow = Math.max(arr[i], arr[i] + bestUpToNow);
            sum = Math.max(sum, bestUpToNow);
        }
        return sum;

    }

    public static int maxSubArrayVisual(int[] arr) {
        // can be done in constant space
        // bestUpToNow is for better visualization at each index
        int sum = Integer.MIN_VALUE;
        int n = arr.length;
        int bestUpToNow[] = new int[n];
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                bestUpToNow[i] = arr[0];
                sum = arr[0];
            }
            bestUpToNow[i] = Math.max(arr[i], arr[i] + bestUpToNow[i - 1]);
            if (bestUpToNow[i] > sum) {
                sum = bestUpToNow[i];
            }
        }
        return sum;
    }

    // kadane's O(N) and constant space
    public static int maxSubArray(int[] arr) {
        int sum = arr[0];
        int bestUpToNow = arr[0];
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            bestUpToNow = Math.max(arr[i], arr[i] + bestUpToNow);
            sum = Math.max(bestUpToNow, sum);
        }
        return sum;
    }

    // O(N^2)
    // public static int maxSubArray(int[] arr) {
    // int sum = Integer.MIN_VALUE;
    // for (int i = 0; i < arr.length; i++) {
    // int runningWindowSum = 0;
    // for (int j = i; j < arr.length; j++) {
    // runningWindowSum += arr[j];
    // if (runningWindowSum > sum) {
    // sum = runningWindowSum;
    // }
    // }
    // }
    // return sum;
    // }
    // O(N^3)
    // public static int maxSubArray(int[] arr) {
    // int dp[][] = new int[arr.length][];
    // int sum = Integer.MIN_VALUE;
    // for (int i = 0; i < arr.length; i++) {
    // dp[i] = new int[arr.length - i];
    // for (int j = 0; j < arr.length - i; j++) {
    // int newSum = sumSubArrInt(arr, i, i + j);
    // dp[i][j] = newSum;
    // if (newSum > sum) {
    // sum = newSum;
    // // res.clear();
    // // int subArr[] = Arrays.copyOfRange(arr, i, i + j + 1);
    // // addToArrayList(res, subArr);
    // }
    // }
    // }
    // return sum;
    // }

    static long sumSubArr(int arr[], int from, int to) {
        long sum = 0;
        for (int i = from; i <= to; i++) {
            sum += arr[i];
        }
        return sum;
    }

    static int sumSubArrInt(int arr[], int from, int to) {
        int sum = 0;
        for (int i = from; i <= to; i++) {
            sum += arr[i];
        }
        return sum;
    }

    static void addToArrayList(ArrayList<Integer> al, int arr[]) {
        for (int x : arr) {
            al.add(x);
        }
    }
}
