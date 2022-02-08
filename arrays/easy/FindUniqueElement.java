package arrays.easy;

import java.util.HashMap;

public class FindUniqueElement {
    public static void main(String[] args) {
        int arr[] = new int[] { 2, 3, 1, 6, 3, 6, 2 };
        FindUniqueElement ob = new FindUniqueElement();
        System.out.println(ob.singleNumber(arr));
    }

    public int singleNumber(int[] nums) {
        int retVal = 0;
        HashMap<Integer, Integer> frequency = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            frequency.put(nums[i], frequency.getOrDefault(nums[i], 0) + 1);
        }
        for (int x : frequency.keySet()) {
            if (frequency.get(x) == 1) {
                retVal = x;
            }
        }
        return retVal;
    }
}
