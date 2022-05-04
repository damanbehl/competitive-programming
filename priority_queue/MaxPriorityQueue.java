package priority_queue;

import java.util.ArrayList;

import exception.PriorityQueueException;

public class MaxPriorityQueue {
    ArrayList<Integer> heap;

    public MaxPriorityQueue() {
        heap = new ArrayList<Integer>();
    }

    public int size() {
        return heap.size();
    }

    public boolean isEmpty() {
        return heap.size() == 0;
    }

    public int getMax() throws PriorityQueueException {
        if (isEmpty()) {
            throw new PriorityQueueException();
        }
        return heap.get(0);
    }

    public void insert(int x) {
        heap.add(x);
        int index = size() - 1;
        int parentIndex = (index - 1) / 2;
        while (index > 0) {
            if (heap.get(parentIndex) < heap.get(index)) {
                int temp = heap.get(parentIndex);
                heap.set(parentIndex, heap.get(index));
                heap.set(index, temp);
                index = parentIndex;
                parentIndex = (index - 1) / 2;
            } else {
                return;
            }
        }
    }

    public int removeMax() throws PriorityQueueException {
        if (isEmpty()) {
            throw new PriorityQueueException();
        }
        int max = heap.get(0);
        heap.set(0, heap.get(size() - 1));
        heap.remove(size() - 1);
        int index = 0;
        int lChildIndex, rChildIndex;
        int maxIndex = index;
        while (index < size() - 1) {
            lChildIndex = 2 * index + 1;
            rChildIndex = 2 * index + 2;
            if (lChildIndex < size() && heap.get(lChildIndex) > heap.get(maxIndex)) {
                maxIndex = lChildIndex;
            }
            if (rChildIndex < size() && heap.get(rChildIndex) > heap.get(maxIndex)) {
                maxIndex = rChildIndex;
            }
            if (index == maxIndex) {
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
}
