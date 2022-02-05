package recursion.low_medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PowerSetOfArray {
    public static void main(String[] args) {
        System.out.println(subsets(new int[] { 1, 2, 3 }));
    }

    public static List<List<Integer>> subsets(int[] nums) {
        return returnAllSubsets(nums, nums.length - 1);
    }

    static List<List<Integer>> returnAllSubsets(int[] nums, int index) {
        List<List<Integer>> allSubsets;
        if (index < 0) {
            allSubsets = new ArrayList<List<Integer>>();
            allSubsets.add(new ArrayList<Integer>());
        } else {
            allSubsets = returnAllSubsets(nums, index - 1);
            int current = nums[index];
            List<List<Integer>> WCN = new ArrayList<List<Integer>>();
            // WITH CURRENT NUMBER
            for (List<Integer> x : allSubsets) {
                List<Integer> y = new ArrayList<Integer>();
                y.addAll(x);
                y.add(current);
                WCN.add(y);
            }
            allSubsets.addAll(WCN);
        }
        return allSubsets;
    }

    static void print(List<Integer> al) {
        for (int x : al) {
            System.out.print(x + " ");
        }
    }
}
