package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PairSumWithoutMap {

    public static void main(String[] args) {
        int[] nums = new int[] { 10, 10, 10, 10, 10, 10, 10, 10, 10, 10 }; // [1, 0, -1, 0, -2, 2]
        int target = 20;
        Arrays.sort(nums);
        System.out.println(twoSumPairs(nums, 0, target));
    }

    static ArrayList<ArrayList<Integer>> twoSumPairs(int arr[], int si, int target) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
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
            ArrayList<Integer> subRes = new ArrayList<>();
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
