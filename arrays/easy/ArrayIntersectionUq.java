package arrays.easy;

import java.util.Arrays;

public class ArrayIntersectionUq {
    public static void main(String[] args) {
        int nums1[] = { 1, 2, 2, 1 };
        int nums2[] = { 2, 2 };
        ArrayIntersectionUq ob = new ArrayIntersectionUq();
        System.out.println(Arrays.toString(ob.intersection(nums1, nums2)));
    }

    public int[] intersection(int[] nums1, int[] nums2) {
        int intersect[] = new int[1000];
        int intersectionCount = 0;
        for (int i = 0; i < nums1.length; i++) {
            intersect[nums1[i]] = 2;
        }
        for (int i = 0; i < nums2.length; i++) {
            if (intersect[nums2[i]] == 2) {
                intersectionCount++;
                intersect[nums2[i]] = 1;
            }
        }
        int result[] = new int[intersectionCount];
        int j = 0;
        for (int i = 0; i < intersect.length; i++) {
            if (intersect[i] == 1) {
                result[j] = i;
                j++;
            }
        }
        return result;
    }
}
