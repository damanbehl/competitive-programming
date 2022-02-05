package recursion.low_medium;

/**
 * submission for masking strat 
 * https://www.pepcoding.com/resources/online-java-foundation/function-and-arrays/subsets_of_array/topic
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PowerSetOfArray {
    public static void main(String[] args) {
        // System.out.println(subsets(new int[] { 1, 2, 3 }));
        // List<List<Integer>> allSubsets = new ArrayList<List<Integer>>();
        // allSubsets.add(new ArrayList<Integer>());
        // printAllSubsets(new int[] { 1, 2, 3 }, 2, allSubsets);
        int emptyArray[][] = { { 0, 0, 0 } };
        printAllSubsetsIndexActivation(new int[] { 1, 2, 3 }, 2, emptyArray);
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

    static void printAllSubsets(int[] nums, int index, List<List<Integer>> accumulatedSubsets) {
        if (index < 0) {
            System.out.println(accumulatedSubsets);
            return;
        } else {
            int current = nums[index];
            List<List<Integer>> WCN = new ArrayList<List<Integer>>();
            // WITH CURRENT NUMBER
            for (List<Integer> x : accumulatedSubsets) {
                List<Integer> y = new ArrayList<Integer>();
                y.addAll(x);
                y.add(current);
                WCN.add(y);
            }
            accumulatedSubsets.addAll(WCN);
            printAllSubsets(nums, index - 1, accumulatedSubsets);
        }
    }

    static void printAllSubsetsIndexActivation(int[] nums, int index, int[][] accumulatedSubsets) {
        if (index < 0) {
            System.out.println(Arrays.deepToString(accumulatedSubsets));
            printMaskedArray(accumulatedSubsets, nums);
            return;
        } else {
            int n = accumulatedSubsets.length;
            int newAccumulatedSets[][] = new int[n * 2][];
            for (int i = 0; i < n; i++) {
                newAccumulatedSets[i] = accumulatedSubsets[i];
            }
            for (int i = 0; i < n; i++) {
                int newSubArray[] = accumulatedSubsets[i].clone();
                newSubArray[index] = 1;
                newAccumulatedSets[i + n] = newSubArray;
            }
            printAllSubsetsIndexActivation(nums, index - 1, newAccumulatedSets);
        }
    }

    static void printMaskedArray(int arr[][], int nums[]) {
        for (int x[] : arr) {
            for (int i = 0; i < x.length; i++) {
                if (x[i] == 0) {
                    System.out.print(" -");
                } else {
                    System.out.print(" " + nums[i]);
                }
            }
            System.out.println();
        }
    }
}
