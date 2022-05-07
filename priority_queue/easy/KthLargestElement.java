package priority_queue.easy;

//https://leetcode.com/problems/kth-largest-element-in-an-array
import java.util.PriorityQueue;

public class KthLargestElement {
    public int findKthLargest(int[] arr, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int i = 0;
        for (; i < k; i++) {
            pq.add(arr[i]);
        }
        for (; i < arr.length; i++) {
            if (pq.element() < arr[i]) {
                pq.remove();
                pq.add(arr[i]);
            }
        }
        return pq.remove();
    }
}
