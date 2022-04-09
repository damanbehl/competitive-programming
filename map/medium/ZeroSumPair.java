package map.medium;

//https://www.codingninjas.com/codestudio/problems/zero-pair-sum_2033591
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Arrays;

public class ZeroSumPair {
    static int ZeroPairSum(int n, ArrayList<Integer> arr) {
        // Write your code here.
        int count = 0;
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int x : arr) {
            hm.put(x, hm.getOrDefault(x, 0) + 1);
        }
        for (int x : arr) {
            int complementCount = hm.getOrDefault(-x, 0);
            if (complementCount > 0) {
                // hm.put(-x,complementCount-1);
                // if(x==0 && complementCount-1<=0){
                // continue;
                // } else if(x==0){
                // count = count + complementCount-1;
                // hm.put(x, hm.get(x)-1);
                // continue;
                // }
                if (x == 0) {
                    complementCount--;
                }
                count += complementCount;
            }
            hm.put(x, hm.get(x) - 1);
        }
        return count;
    }

    // linear time single traversal, final test case passed
    static int ZeroPairSumBetter(int n, ArrayList<Integer> arr) {
        // Write your code here.
        int count = 0;
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int x : arr) {
            int complementCount = hm.getOrDefault(-x, 0);
            if (complementCount > 0) {
                count += complementCount;
            }
            hm.put(x, hm.getOrDefault(x, 0) + 1);
        }
        return count;
    }

    // ordered
    public static int[][] pairSum(int[] arr, int s) {
        // Write your code here.
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        HashMap<Integer, Integer> freq = new HashMap<>();
        Arrays.sort(arr);
        for (int x : arr) {
            freq.put(x, freq.getOrDefault(x, 0) + 1);
            int rem = freq.getOrDefault(s - x, 0);
            if (rem == 0) {
                continue;
            }
            if (x == (s - x)) {
                rem--;
            }
            for (int i = 0; i < rem; i++) {
                ArrayList<Integer> subRes = new ArrayList<>();
                subRes.add(s - x);
                subRes.add(x);
                result.add(subRes);
            }
        }
        int[][] proper = new int[result.size()][2];
        int index = 0;
        for (int i = 0; i < result.size(); i++) {
            proper[index][0] = result.get(result.size() - 1 - i).get(0);
            proper[index][1] = result.get(result.size() - 1 - i).get(1);
            index++;
        }
        return proper;
    }
}
