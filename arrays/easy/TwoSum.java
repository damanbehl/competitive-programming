package arrays.easy;

//https://leetcode.com/problems/two-sum/
import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {
    public static void main(String[] args) {
        TwoSum ob = new TwoSum();
        int input[] = { 3, 3 };
        System.out.println(Arrays.toString(ob.twoSum(input, 6)));
    }

    public int[] twoSum(int[] nums, int target) {
        int result[] = new int[2];
        HashMap<Integer, Integer> frequency = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (frequency.get(nums[i]) == null) {
                int difference = target - nums[i];
                if (frequency.get(difference) != null) {
                    result[0] = frequency.get(difference);
                    result[1] = i;
                    break;
                } else {
                    frequency.put(nums[i], i);
                }
            } else if (nums[i] + nums[i] == target) {
                result[0] = frequency.get(nums[i]);
                result[1] = i;
                break;
            }
        }
        return result;
    }

}
