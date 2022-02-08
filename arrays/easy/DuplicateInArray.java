package arrays.easy;

import java.util.HashMap;

public class DuplicateInArray {
    public int solve(int[] nums) {
        int retVal = 0;
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (hm.getOrDefault(nums[i], 0) != 0) {
                retVal = nums[i];
                break;
            } else {
                hm.put(nums[i], 1);
            }
        }
        return retVal;
    }
}
