/**
 * https://leetcode.com/problems/4sum/
 */
package arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class KSumUniqueTarget {
    public static void main(String[] args) {
        int nums[] = { 2, 2, 2, 2, 2 };
        int target = 8;
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        System.out.println(kSumHelper(nums, target, 0, 4));
    }

    static List<List<Integer>> kSumHelper(int arr[], int target, int si, int k) {
        List<List<Integer>> result = new ArrayList<>();
        int n = arr.length;
        if (n - si < k) {
            return result;
        }
        if (k == 2) {
            return twoSumPairs(arr, si, target);
        }
        for (int i = si; i <= n - k; i++) {
            List<List<Integer>> subRes = new ArrayList<>();
            /**
             * to Avoid repeating for same valued element
             */
            if (i != si && arr[i] == arr[i - 1]) {
                continue;
            }

            subRes = kSumHelper(arr, target - arr[i], i + 1, k - 1);
            for (List<Integer> individualList : subRes) {
                individualList.add(arr[i]);
                result.add(individualList);
            }
        }
        return result;
    }

    static List<List<Integer>> twoSumPairs(int arr[], int si, int target) {
        List<List<Integer>> res = new ArrayList<>();
        int n = arr.length;
        if (n - si < 2) {
            return res;
        }
        int left = si;
        int right = n - 1;
        while (left < right) {
            /**
             * to check unique
             * comment if repetition is allowed afterwards accordingly
             */
            if (left != si && arr[left] == arr[left - 1]) {
                left++;
                continue;
            }
            List<Integer> subRes = new ArrayList<>();
            int sum = arr[left] + arr[right];
            if (sum == target) {
                subRes.add(arr[left]);
                subRes.add(arr[right]);
                left++;
                right--;
                res.add(subRes);
            } else if (sum > target) {
                right--;
            } else {
                left++;
            }
        }
        return res;
    }
}
