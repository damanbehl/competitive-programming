/**
 * https://leetcode.com/problems/trapping-rain-water/
 */
package misc;

import java.util.ArrayList;

public class GatherRainWater {
    public static void main(String[] args) {
        // System.out.println(trap(new int[] { 0, 1, 2, 0, 3, 0, 1, 2, 0, 0, 4, 2, 1, 2,
        // 5, 0, 1, 2, 0, 2 }));
        System.out.println("the result is" + trap(new int[] { 3, 3, 1, 5, 4, 4, 8 }));
    }

    // public static long getTrappedWater(long[] arr, int n) {
    // // Write your code here.
    // }

    public static int trap(int[] height) {
        if (height.length < 3) {
            return 0;
        }
        // return getTrappedWaterHelper(height, 0, height.length - 1);
        return getTrappedWaterHelperNew(height, 0, height.length - 1);
    }

    /**
     * draft version
     * 
     * @param al
     */
    // static int getTrappedWaterHelper(int arr[], int i, int j) {
    // int sum = 0;
    // while (i < j) {
    // int staticI = i;
    // ArrayList<Integer> al = new ArrayList<Integer>();
    // while (arr[staticI] > arr[++i] && i < j) {
    // sum = sum + (arr[staticI] - arr[i]);
    // al.add(arr[staticI] - arr[i]);
    // }
    // if (i == j && arr[staticI] > arr[j]) {
    // // sum = sum - ((arr[staticI] - arr[j]) * (i - staticI - 1));
    // int factorBetween = 0;
    // int backTrack = i;
    // while (al.size() > 0) {
    // if (arr[--backTrack] <= arr[j]) {
    // // sum = sum - (arr[staticI] - arr[j]) + factorBetween;
    // sum = sum - (arr[staticI] - arr[j]);
    // } else {
    // sum = sum - al.get(al.size() - 1);
    // // factorBetween = arr[backTrack] - arr[j];
    // j = backTrack;
    // }
    // al.remove(al.size() - 1);
    // }
    // }
    // al = new ArrayList<Integer>();
    // int staticJ = j;
    // while (arr[staticJ] > arr[--j] && j > i) {
    // al.add(arr[staticJ] - arr[j]);
    // sum = sum + (arr[staticJ] - arr[j]);
    // }
    // if (i == j && arr[staticJ] > arr[j]) {
    // int factorBetween = 0;
    // int backTrack = j;
    // while (al.size() > 0) {
    // if (arr[++backTrack] <= arr[j]) {
    // // sum = sum - (arr[staticJ] - arr[j]) + factorBetween;
    // sum = sum - (arr[staticJ] - arr[j]);
    // } else {
    // sum = sum - al.get(al.size() - 1);
    // // factorBetween = arr[backTrack] - arr[j];
    // j = backTrack;
    // }
    // al.remove(al.size() - 1);
    // }
    // }
    // }
    // return sum;
    // }

    // static void print(ArrayList<Integer> al) {
    // // System.out.println(" ");
    // for (int x : al) {
    // System.out.print(x + " ");
    // }
    // System.out.println(" ");
    // }

    static int getTrappedWaterHelperNew(int arr[], int i, int j) {
        int sum = 0;
        int newSum = 0;
        boolean quitLoop = false;
        while (i < j) {
            int staticI = i;
            ArrayList<Integer> al = new ArrayList<Integer>();
            while (arr[staticI] > arr[++i] && i < j) {
                sum = sum + (arr[staticI] - arr[i]);
                al.add(arr[staticI] - arr[i]);
            }
            if (i == j && arr[staticI] > arr[j]) {
                quitLoop = true;
                int backTrack = i;
                for (int iter = al.size() - 1; iter >= 0; iter--) {
                    if (arr[--backTrack] <= arr[j]) {
                        al.set(iter, al.get(iter) - (arr[staticI] - arr[j]));
                    } else {
                        al.set(iter, al.get(iter) - (arr[staticI] - arr[backTrack]));
                        j = backTrack;
                    }
                }
            }
            newSum += sum(al);
            al = new ArrayList<Integer>();
            int staticJ = j;
            while (arr[staticJ] > arr[--j] && j > i) {
                al.add(arr[staticJ] - arr[j]);
                sum = sum + (arr[staticJ] - arr[j]);
            }
            if (i == j && arr[staticJ] > arr[j]) {
                quitLoop = true;
                int backTrack = j;
                for (int iter = al.size() - 1; iter >= 0; iter--) {
                    if (arr[++backTrack] <= arr[j]) {
                        al.set(iter, al.get(iter) - (arr[staticJ] - arr[j]));
                    } else {
                        al.set(iter, al.get(iter) - (arr[staticJ] - arr[backTrack]));
                        j = backTrack;
                    }
                }
            }
            newSum += sum(al);
            if (quitLoop == true) {
                break;
            }
        }

        return newSum;
    }

    static int sum(ArrayList<Integer> al) {
        int sum = 0;
        for (int x : al) {
            sum += x;
        }
        return sum;
    }
}
