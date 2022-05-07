package priority_queue.medium;

//https://www.codingninjas.com/codestudio/problems/convert-min-heap-to-max-heap_630293
public class minToMaxHeap {
    public static void minHeapToMaxHeap(long[] arr) {
        // Your code goes here.
        int n = arr.length;
        for (int i = (n - 2) / 2; i >= 0; i--) {
            maxHeapify(arr, i, n);
        }
    }

    // start by the inner rightmost node, will recurse deeper for subtree where
    // largest was found if it is within bounds
    public static void maxHeapify(long arr[], int i, int n) {
        int lChild = 2 * i + 1;
        int rChild = 2 * i + 2;
        int largest = i;
        if (lChild < n && arr[lChild] > arr[largest]) {
            largest = lChild;
        }
        if (rChild < n && arr[rChild] > arr[largest]) {
            largest = rChild;
        }
        if (i != largest) {
            long temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;
            maxHeapify(arr, largest, n);
        }
    }
}
