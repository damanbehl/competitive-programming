package recursion.low_medium;

import java.util.ArrayList;
import java.util.Collections;

/**
 * https://www.codingninjas.com/codestudio/problems/return-subsets-sum-to-k_759331
 */
public class SubsetsSumToK {

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        Collections.addAll(arr, new Integer[] { 5, -1, 8, 2, 7, 0 });
        int k = 7;
        System.out.println(findSubsetsThatSumToK(arr, arr.size() - 1, k));
    }

    public static ArrayList<ArrayList<Integer>> findSubsetsThatSumToK(ArrayList<Integer> arr, int n, int k) {
        // Write your code here.
        ArrayList<ArrayList<Integer>> allSubsets = helper(arr, arr.size() - 1, k);
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        for (ArrayList<Integer> x : allSubsets) {
            if (sum(x) == k) {
                result.add(x);
            }
        }
        return result;
    }

    public static ArrayList<ArrayList<Integer>> helper(ArrayList<Integer> arr, int n, int k) {
        ArrayList<ArrayList<Integer>> allSubsets;
        if (n < 0) {
            allSubsets = new ArrayList<ArrayList<Integer>>();
            ArrayList<Integer> singleElem = new ArrayList<Integer>();
            allSubsets.add(singleElem);
        } else {
            int currentElem = arr.get(n);
            allSubsets = helper(arr, n - 1, k);
            ArrayList<ArrayList<Integer>> moreSubsets = new ArrayList<ArrayList<Integer>>();
            for (ArrayList<Integer> x : allSubsets) {
                ArrayList<Integer> clone = new ArrayList<Integer>();
                clone.addAll(x);
                clone.add(currentElem);
                moreSubsets.add(clone);
            }
            allSubsets.addAll(moreSubsets);
        }
        return allSubsets;
    }

    static int sum(ArrayList<Integer> toSum) {
        int sum = 0;
        for (int x : toSum) {
            sum += x;
        }
        return sum;
    }
}
