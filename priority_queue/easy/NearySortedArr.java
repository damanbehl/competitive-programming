package priority_queue.easy;

//https://www.codingninjas.com/codestudio/problems/nearly-sorted_982937
import java.util.PriorityQueue;

public class NearySortedArr {
    public static int[] nearlySorted(int[] arr, int n, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int i = 0;
        for (; i < k; i++) {
            pq.add(arr[i]);
        }
        for (; i < arr.length; i++) {
            arr[i - k] = pq.remove();
            pq.add(arr[i]);
        }
        for (int j = arr.length - k; j < arr.length; j++) {
            arr[j] = pq.remove();
        }
        return arr;
    }
}
