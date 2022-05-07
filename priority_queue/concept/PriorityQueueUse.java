package priority_queue.concept;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

import exception.PriorityQueueException;

public class PriorityQueueUse {
    public static void main(String[] args) throws PriorityQueueException {
        String[] arr = { "this", "at", "a", "their", "queues" };
        StringLengthComparator comp = new StringLengthComparator();
        PriorityQueue<String> pq = new PriorityQueue<>(comp);

        // MaxPQComparator maxComp = new MaxPQComparator();

        // Custom PQ
        // Priority_Queue pq = new Priority_Queue();

        // Ways to initialize max priority queue (self or inbuilt comparator)
        // PriorityQueue<Integer> pqMax = new PriorityQueue<>(maxComp);
        // PriorityQueue<Integer> pqMax = new
        // PriorityQueue<>(Collections.reverseOrder());
        // MaxPriorityQueue pqMax = new MaxPriorityQueue();
        // int arr[] = { 22, 99, 11, 0, 5, 4 };

        // Heap sort time comp : O(nlogn) space complexity = O(n)
        // for (int x : arr) {
        // pq.insert(x);
        // }
        // while (!pq.isEmpty()) {
        // System.out.print(pq.removeMinSimpler() + " ");
        // }

        for (int i = 0; i < arr.length; i++) {
            pq.add(arr[i]);
        }
        while (!pq.isEmpty()) {
            System.out.print(pq.remove() + " ");
        }
    }
}

class MaxPQComparator implements Comparator<Integer> {
    // based on length
    @Override
    public int compare(Integer o1, Integer o2) {
        if (o1 < o2) {
            return 1;
        } else if (o1 > o2) {
            return -1;
        } else {
            return 0;
        }
    }
}

class StringLengthComparator implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        if (o1.length() < o2.length()) {
            return -1;
        } else if (o1.length() > o2.length()) {
            return 1;
        } else {
            return 0;
        }
    }

}