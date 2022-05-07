package priority_queue.easy;

import java.util.PriorityQueue;

public class KLargestBetter {
    int[] kLargest(int[] arr, int n, int k) {
        // code here
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
        int res[] = new int[k];
        for (i = 0; i < k; i++) {
            res[k - i - 1] = pq.remove();
        }
        return res;
    }
}
