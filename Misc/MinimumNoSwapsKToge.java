package misc;

/**
 * https://practice.geeksforgeeks.org/problems/minimum-swaps-required-to-bring-all-elements-less-than-or-equal-to-k-together4847/1/
 * 
 * https://www.codingninjas.com/codestudio/problems/minimum-swaps-to-bring-all-elements-less-than-or-equal-to-k-together_1112657
 */
public class MinimumNoSwapsKToge {
    public static void main(String[] args) {
        int input[] = { 10, 12, 20, 20, 5, 19, 19, 12, 1, 20, 1 };
        System.out.println(minSwap(input, input.length, 1));
    }

    static int minSwap(int arr[], int n, int k) {
        int windowLength = count(arr, k);
        int minSwapCount = n;
        for (int i = 0; i <= n - windowLength; i++) {
            int greaterCount = 0;
            for (int j = i; j < windowLength + i; j++) {
                if (arr[j] > k) {
                    greaterCount++;
                }
            }
            minSwapCount = Math.min(greaterCount, minSwapCount);
        }
        return minSwapCount;
    }

    // look's like a variation of k's
    static int minSwapLinearTime(int arr[], int n, int k) {
        int windowLength = count(arr, k);
        int minSwapCount = n;
        int currentMinSwap = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] > k) {
                currentMinSwap++;
            }
            if (i >= windowLength && arr[i - windowLength] > k) {
                currentMinSwap--;
            }
            if (i >= windowLength - 1) {
                minSwapCount = Math.min(minSwapCount, currentMinSwap);
            }
        }
        return minSwapCount;
    }

    static int count(int arr[], int k) {
        int lesserCount = 0;
        for (int x : arr) {
            if (x <= k) {
                lesserCount++;
            }
        }
        return lesserCount;
    }
}
