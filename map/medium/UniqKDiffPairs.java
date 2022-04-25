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
}
