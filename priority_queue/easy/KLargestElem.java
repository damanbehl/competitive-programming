package priority_queue.easy;

//https://practice.geeksforgeeks.org/problems/k-largest-elements4206
// https://leetcode.com/problems/kth-largest-element-in-an-array
import java.util.*;

class Solution {
    int[] kLargest(int[] arr, int n, int k) {
        // code here
        MaxPQ pq = new MaxPQ();
        for (int x : arr) {
            pq.insert(x);
        }
        int res[] = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = pq.removeMax();
        }
        return res;
    }

    public static class MaxPQ {
        private ArrayList<Integer> heap;

        public MaxPQ() {
            heap = new ArrayList<Integer>();
        }

        public int size() {
            return heap.size();
        }

        public boolean isEmpty() {
            return heap.size() == 0;
        }

        public int removeMax() {
            int max = heap.get(0);
            heap.set(0, heap.get(size() - 1));
            heap.remove(size() - 1);
            int index = 0;
            int maxIndex = index, lChildIndex, rChildIndex;
            while (index < size() - 1) {
                lChildIndex = 2 * index + 1;
                rChildIndex = 2 * index + 2;
                if (lChildIndex < size() && heap.get(lChildIndex) > heap.get(maxIndex)) {
                    maxIndex = lChildIndex;
                }
                if (rChildIndex < size() && heap.get(rChildIndex) > heap.get(maxIndex)) {
                    maxIndex = rChildIndex;
                }
                if (maxIndex == index) {
                    break;
                } else {
                    int temp = heap.get(index);
                    heap.set(index, heap.get(maxIndex));
                    heap.set(maxIndex, temp);
                    index = maxIndex;
                }
            }
            return max;
        }

        public void insert(int elem) {
            heap.add(elem);
            int index = size() - 1;
            int parentIndex;
            while (index > 0) {
                parentIndex = (index - 1) / 2;
                if (heap.get(parentIndex) < heap.get(index)) {
                    int temp = heap.get(parentIndex);
                    heap.set(parentIndex, heap.get(index));
                    heap.set(index, temp);
                    index = parentIndex;
                } else {
                    break;
                }
            }
        }
    }
}
