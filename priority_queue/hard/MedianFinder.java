package priority_queue.hard;

//https://leetcode.com/problems/find-median-from-data-stream
import java.util.Collections;
import java.util.PriorityQueue;

class MedianFinder {
    PriorityQueue<Integer> smallHeap;
    PriorityQueue<Integer> largeHeap;

    public MedianFinder() {
        smallHeap = new PriorityQueue<>(Collections.reverseOrder());
        largeHeap = new PriorityQueue<>();
    }

    public void addNum(int num) {
        if (largeHeap.size() > 0 && num > largeHeap.peek()) {
            largeHeap.add(num);
        } else {
            smallHeap.add(num);
        }
        rebalance();
    }

    public void rebalance() {
        int smSize = smallHeap.size();
        int lgSize = largeHeap.size();
        if (smSize > lgSize && (smSize - lgSize) > 1) {
            largeHeap.add(smallHeap.poll());
        } else if (lgSize > smSize && (lgSize - smSize) > 1) {
            smallHeap.add(largeHeap.poll());
        }
    }

    public double findMedian() {
        double res = 0;
        int size = smallHeap.size() + largeHeap.size();
        if (size % 2 == 0) {
            int leftMid = smallHeap.peek();
            int rightMid = largeHeap.peek();
            res = ((leftMid + rightMid) * 1.0) / 2;
        } else {
            if (smallHeap.size() > largeHeap.size()) {
                res = smallHeap.peek();
            } else {
                res = largeHeap.peek();
            }
        }
        return res;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */