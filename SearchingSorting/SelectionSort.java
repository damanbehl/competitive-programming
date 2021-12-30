package SearchingSorting;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int nums[] = new int[] { 10, 90, 20, 80, 30, 45, 60, 23, 23, 23, -23, -23 };
        System.out.println(Arrays.toString(selectionSort(nums, nums.length)));
    }

    static int[] selectionSort(int nums[], int n) {
        for (int i = 0; i < n; i++) {
            int minIndex = i;
            for (int j = i; j < n; j++) {
                if (nums[j] < nums[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = nums[i];
            nums[i] = nums[minIndex];
            nums[minIndex] = temp;
        }
        return nums;
    }
}
