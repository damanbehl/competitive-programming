package priority_queue.concept;

import java.util.ArrayList;

import exception.PriorityQueueException;

public class Priority_Queue {
    private ArrayList<Integer> heap;

    public Priority_Queue() {
        heap = new ArrayList<>();
    }

    boolean isEmpty() {
        return heap.size() == 0;
    }

    int size() {
        return heap.size();
    }

    int getMin() throws PriorityQueueException {
        if (isEmpty()) {
            throw new PriorityQueueException();

        }
        return heap.get(0);
    }

    void insert(int element) {
        // up-heapify
        heap.add(element);
        int childIndex = heap.size() - 1;
        int parentIndex = (childIndex - 1) / 2;
        while (childIndex > 0) {
            if (heap.get(childIndex) < heap.get(parentIndex)) {
                int temp = heap.get(parentIndex);
                heap.set(parentIndex, heap.get(childIndex));
                heap.set(childIndex, temp);
                childIndex = parentIndex;
                parentIndex = (childIndex - 1) / 2;
            } else {
                return;
            }
        }
    }

    int removeMin() throws PriorityQueueException {
        if (isEmpty()) {
            PriorityQueueException e = new PriorityQueueException();
            throw e;
        }
        int min = heap.get(0);
        heap.set(0, heap.get(size() - 1));
        heap.remove(size() - 1);
        int parentIndex = 0;
        int lChildIndex = 2 * parentIndex + 1;
        int rChildIndex = 2 * parentIndex + 2;
        // down -heapify
        while (parentIndex < size() - 1) {
            lChildIndex = 2 * parentIndex + 1;
            rChildIndex = 2 * parentIndex + 2;
            int leftChildVal = Integer.MAX_VALUE;
            int rightChildVal = Integer.MAX_VALUE;
            if (lChildIndex <= size() - 1) {
                leftChildVal = heap.get(lChildIndex);
            }
            if (rChildIndex <= size() - 1) {
                rightChildVal = heap.get(rChildIndex);
            }
            int parentVal = heap.get(parentIndex);
            int minVal = Math.min(leftChildVal, Math.min(rightChildVal, parentVal));
            if (minVal < parentVal) {
                // repindex: index to be replaced
                int repIndex;
                if (leftChildVal == minVal) {
                    repIndex = lChildIndex;
                } else {
                    repIndex = rChildIndex;
                }
                int temp = heap.get(repIndex);
                heap.set(repIndex, parentVal);
                heap.set(parentIndex, temp);
                parentIndex = repIndex;
            } else {
                return min;
            }
        }
        return min;
    }

    public int removeMinSimpler() throws PriorityQueueException {
        if (isEmpty()) {
            throw new PriorityQueueException();
        }
        int min = heap.get(0);
        heap.set(0, heap.get(heap.size() - 1));
        heap.remove(size() - 1);
        int parentIndex = 0;
        int minIndex = 0;
        int lChildIndex, rChildIndex;
        while (parentIndex < size() - 1) {
            lChildIndex = 2 * parentIndex + 1;
            rChildIndex = 2 * parentIndex + 2;
            if (lChildIndex < size() && heap.get(lChildIndex) < heap.get(minIndex)) {
                minIndex = lChildIndex;
            }
            if (rChildIndex < size() && heap.get(rChildIndex) < heap.get(minIndex)) {
                minIndex = rChildIndex;
            }
            if (minIndex == parentIndex) {
                break;
            } else {
                int temp = heap.get(parentIndex);
                heap.set(parentIndex, heap.get(minIndex));
                heap.set(minIndex, temp);
                parentIndex = minIndex;
            }
        }
        return min;
    }
}