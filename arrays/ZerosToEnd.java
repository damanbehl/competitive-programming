/**
 * https://www.codingninjas.com/codestudio/problems/push-zeros-to-end_583
 */

package arrays;

import java.util.Arrays;

public class ZerosToEnd {
    public static void main(String[] args) {
        int nums[] = new int[] { 5, 8, 7, 4, 3, 1 };
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
        // System.out.println("result is" + Arrays.toString(moveZerosToRight(new int[] {
        // 0, 3, 0, 2, 0 })));
    }

    /**
     * Two pointer approach fast and slow pointer
     * traversal is once, no extra space taken
     * 
     * @param nums
     */
    public static void moveZeroes(int[] nums) {
        // lastNonZeroFoundAt is actually tracking where the last zero is, we are
        // incrementing beforehand and swapping with next non zero therby maintaining
        // order while
        // taking care of all non-zeroes in the way making sure we do not have data loss
        int lastNonZeroFoundAt = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                // nums[i] = nums[i] ^ nums[lastNonZeroFoundAt];
                // nums[lastNonZeroFoundAt] = nums[i] ^ nums[lastNonZeroFoundAt];
                // nums[i] = nums[i] ^ nums[lastNonZeroFoundAt];
                int temp = nums[i];
                nums[i] = nums[lastNonZeroFoundAt];
                nums[lastNonZeroFoundAt] = temp;
                lastNonZeroFoundAt++;
            }
        }
    }

    /**
     * overly complicated approach, do not do this
     * 
     * @param nums
     * @return
     */
    static int[] moveZerosToRight(int nums[]) {
        if (nums.length == 0 || nums.length == 1) {
            return nums;
        }
        int left;
        int right;
        if (nums.length % 2 == 0) {
            left = (nums.length / 2) - 1;
            right = (nums.length / 2);
        } else {
            left = nums.length / 2;
            right = nums.length / 2 + 1;
        }
        int count = 0;
        // System.out.println("left" + left + ", right" + right);
        boolean forward = true;
        while (left < right) {
            // System.out.println("count is>>" + count + ">>forward>>" + forward);
            // System.out.println("arr is " + Arrays.toString(nums));
            if (right > nums.length - 1) {
                // System.out.println("flipped on reaching end");
                forward = false;
                left--;
                right--;
                count++;
                continue;
            }

            // System.out.println("lft index>" + left + " right index>" + right);
            // System.out.println("lft>" + nums[left] + " right" + nums[right]);
            if (forward == false && left == 0) {
                if (nums[left] == 0 && nums[right] == 0) {
                    break;
                }
                if (nums[left] != 0 && nums[right] != 0) {
                    break;
                }
                if (nums[right] == 0 && nums[left] != 0) {
                    break;
                }
            }
            if (nums[left] == 0 && nums[right] == 0) {
                if (forward) {
                    if (right == nums.length - 1) {
                        // System.out.println("flipped on reaching end");
                        forward = false;
                        left--;
                        right--;
                    }
                    left++;
                    right++;
                } else {
                    left--;
                    right--;
                }
            } else if (nums[left] == 0 && nums[right] != 0) {
                nums[left] = nums[left] ^ nums[right];
                nums[right] = nums[left] ^ nums[right];
                nums[left] = nums[left] ^ nums[right];
                forward = true;
                left++;
                right++;
            } else if (nums[left] != 0 && nums[right] == 0) {
                if (forward) {
                    left++;
                    right++;
                } else {
                    left--;
                    right--;
                }
            }

            else if (nums[left] != 0 && nums[right] != 0) {
                if (forward) {
                    left++;
                    right++;
                } else {
                    left--;
                    right--;
                }
            }

            count++;
            // System.out.println("Iteration>+" + count + "ends");
        }
        return nums;
    }

}
