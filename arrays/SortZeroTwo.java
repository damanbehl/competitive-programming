/**
 * variation of dutch national flag problem
 * https://leetcode.com/problems/sort-colors/submissions/
 */
package arrays;

import java.util.Arrays;

public class SortZeroTwo {
    public static void main(String[] args) {
        int inputArr[] = new int[] { 2, 0, 2, 1, 1, 0 };
        // int inputArr[] = new int[] { 2, 0, 1 };
        sortColors(inputArr);
        System.out.println(Arrays.toString(inputArr));
    }

    public static void sortColors(int[] nums) {
        int low = 0;
        int mid = 0;
        int high = nums.length - 1;
        for (int i = 0; i < nums.length && mid <= high; i++) {
            if (nums[i] == 0) {
                nums[i] = nums[low];
                nums[low] = 0;
                low++;
                mid++;
            } else if (nums[i] == 1) {
                mid++;
            } else {
                nums[i] = nums[high];
                nums[high] = 2;
                i--;
                high--;
            }
        }
    }
}
