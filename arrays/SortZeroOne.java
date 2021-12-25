/**
 * https://www.codingninjas.com/codestudio/problems/binary-array-sorting_985289
 */

package arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class SortZeroOne {
    public static void main(String[] args) {
        // System.out.println(Arrays.toString(sortArray(new int[] { 0, 1, 1, 0, 1, 0, 1
        // })));
        // System.out.println(Arrays.toString(sortArray(new int[] { 1, 0, 1, 1, 0, 1, 0,
        // 1 })));

    }

    public static int[] sortArray(int inputArr[]) {
        int left = 0;
        int right = inputArr.length - 1;
        while (left < right) {
            if (inputArr[left] == 1 && inputArr[right] == 0) {
                inputArr[left] = inputArr[left] ^ inputArr[right];
                inputArr[right] = inputArr[left] ^ inputArr[right];
                inputArr[left] = inputArr[left] ^ inputArr[right];
                right--;
                left++;
            } else if (inputArr[left] == 1 && inputArr[right] == 1) {
                right--;
            } else if (inputArr[left] == 0 && inputArr[right] == 1) {
                left++;
            } else {
                left++;
            }
        }
        return inputArr;
    }

    public static ArrayList<Integer> sortBinaryArray(ArrayList<Integer> arr, int n) {
        int left = 0;
        int right = arr.size() - 1;
        while (left < right) {
            int leftElem = arr.get(left);
            int rightElem = arr.get(right);
            if (leftElem == 1 && rightElem == 0) {
                leftElem = leftElem ^ rightElem;
                rightElem = leftElem ^ rightElem;
                leftElem = leftElem ^ rightElem;
                arr.set(left, leftElem);
                arr.set(right, rightElem);
                right--;
                left++;
            } else if (leftElem == 1 && rightElem == 1) {
                right--;
            } else if (leftElem == 0 && rightElem == 1) {
                left++;
            } else {
                left++;
            }
        }
        return arr;
    }
}
