/**
 * https://leetcode.com/problems/rotate-array/
 * https://www.codingninjas.com/codestudio/problems/rotate-array_1230543
 */
package arrays;

import java.util.Arrays;

public class RotateArrayByInt {
    // public static void main(String[] args) {
    // Scanner sc = new Scanner(System.in);
    // int size = sc.nextInt();
    // int arr[] = new int[size];
    // for (int i = 0; i < size; i++) {
    // arr[i] = sc.nextInt();
    // }
    // int d = sc.nextInt();
    // rotateArrayToRight(arr, d);
    // sc.close();
    // }
    public static void main(String[] args) {
        // Scanner sc = new Scanner(System.in);
        // int size = sc.nextInt();
        // int arr[] = new int[size];
        // for (int i = 0; i < size; i++) {
        // arr[i] = sc.nextInt();
        // }
        // int d = sc.nextInt();
        rotateToRight(new int[] { 1, 2, 3 }, 40);
        // sc.close();
    }

    public static void rotateArray(int arr[], int d) {
        int size = arr.length;
        int offset = d;
        int result[] = new int[size];
        for (int i = 0; i < size; i++) {
            if (d > 0) {
                result[size - d] = arr[i];
                d--;
            } else {
                result[i - offset] = arr[i];
            }
        }
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }

    /**
     * case where d>size requires that we reduce d by taking the modulo with size
     * since
     * rotations equal to the size of the array will equate to the order of the
     * original array hence the modulous operation on the number of steps
     * 
     * @param arr
     * @param d
     */

    public static void rotateToRight(int[] arr, int d) {
        int size = arr.length;
        if (size >= 2) {
            if (d > size) {
                d = d % size;
            }
            int offset = d;
            int result[] = Arrays.copyOf(arr, size);
            for (int i = 0; i < size; i++) {
                if (d > 0) {
                    arr[i] = result[size - d];
                    d--;
                } else {
                    arr[i] = result[i - offset];
                }
            }
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i] + " ");
            }
        }

    }

    public void rotateZeroNoExtraSpace(int nums[], int k) {
        k = k % nums.length;
        // reverse entire array
        reverse(nums, 0, nums.length - 1);
        // reverse part that has to be rotated
        reverse(nums, 0, k - 1);
        // reverse rest of the array
        reverse(nums, k, nums.length - 1);
    }

    static void reverse(int nums[], int i, int j) {
        while (i < j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }
}
