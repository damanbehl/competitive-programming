package priority_queue;

import exception.PriorityQueueException;

public class PriorityQueueUse {
    public static void main(String[] args) throws PriorityQueueException {
        Priority_Queue pq = new Priority_Queue();
        MaxPriorityQueue pqMax = new MaxPriorityQueue();
        int arr[] = { 22, 99, 11, 0, 5, 4 };
        // Heap sort time comp : O(nlogn) space complexity = O(n)
        // for (int x : arr) {
        // pq.insert(x);
        // }
        // while (!pq.isEmpty()) {
        // System.out.print(pq.removeMinSimpler() + " ");
        // }
        for (int x : arr) {
            pqMax.insert(x);
        }
        while (!pqMax.isEmpty()) {
            System.out.print(pqMax.removeMax() + " ");
        }
    }
}
