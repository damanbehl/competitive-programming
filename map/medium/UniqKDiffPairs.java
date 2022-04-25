package map.medium;

import java.util.HashMap;

public class UniqKDiffPairs {
    public static void main(String[] args) {
        int nums[] = { 1, -1 };
        System.out.println(findPairs(nums, 2));
    }

    public static int findPairs(int[] nums, int k) {
        if (k < 0) {
            return 0;
        }
        int result = 0;
        HashMap<Integer, Integer> freq = new HashMap<>();
        for (int x : nums) {
            freq.put(x, freq.getOrDefault(x, 0) + 1);
        }
        for (int x : freq.keySet()) {
            if (k == 0) {
                if (freq.get(x) > 1) {
                    result++;
                }
            } else {
                if (freq.containsKey(x + k)) {
                    result++;
                }
            }
        }
        return result;
    }

    // with rep
    // https://www.codingninjas.com/codestudio/problems/pair-with-diff-k_5393
    public static int getPairsWithDifferenceK(int nums[], int k) {
        if (k < 0) {
            return 0;
        }
        int result = 0;
        HashMap<Integer, Integer> freq = new HashMap<>();
        for (int x : nums) {
            freq.put(x, freq.getOrDefault(x, 0) + 1);
        }
        for (int x : nums) {
            int xcount = freq.get(x);
            if (k == 0) {
                if (xcount > 1) {
                    freq.put(x, xcount - 1);
                    result = result + xcount - 1;
                }
            } else {
                int ccount = freq.getOrDefault(x + k, 0);
                if (ccount > 0) {
                    freq.put(x, xcount - 1);
                    result += ccount;
                }
            }
        }
        return result;
    }
}
