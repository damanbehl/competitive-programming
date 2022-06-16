package priority_queue.hard;

//https://leetcode.com/problems/median-of-two-sorted-arrays/
import java.util.Collections;
import java.util.PriorityQueue;

public class MedianOfTwoSorted {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        PriorityQueue<Integer> MSH = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> MLH = new PriorityQueue<>();
        insert(MSH, MLH, nums1);
        insert(MSH, MLH, nums2);
        int totalsize = nums1.length + nums2.length;
        if (totalsize % 2 == 0) {
            return ((MSH.peek() + MLH.peek()) * 1.0) / 2;
        } else {
            if (MSH.size() > MLH.size()) {
                return MSH.peek() * 1.0;
            } else {
                return MLH.peek() * 1.0;
            }
        }
    }

    public static void insert(PriorityQueue<Integer> p1, PriorityQueue<Integer> p2, int nums[]) {
        for (int i = 0; i < nums.length; i++) {
            if (p2.size() > 0 && nums[i] > p2.peek()) {
                p2.add(nums[i]);
            } else {
                p1.add(nums[i]);
            }
            rebalance(p1, p2);
        }
    }

    public static void rebalance(PriorityQueue<Integer> p1, PriorityQueue<Integer> p2) {
        if ((p1.size() - p2.size()) > 1) {
            p2.add(p1.poll());
        } else if ((p2.size() - p1.size()) > 1) {
            p1.add(p2.poll());
        }
    }
}
