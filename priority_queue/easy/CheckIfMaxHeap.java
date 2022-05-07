package priority_queue.easy;

//https://practice.geeksforgeeks.org/problems/does-array-represent-heap4345
public class CheckIfMaxHeap {
    public boolean countSub(long arr[], long n) {
        int i = 0;
        int lChild, rChild;
        while (i < n) {
            lChild = 2 * i + 1;
            rChild = 2 * i + 2;
            if (lChild < n && arr[i] < arr[lChild]) {
                return false;
            }
            if (rChild < n && arr[i] < arr[rChild]) {
                return false;
            }
            i++;
        }
        return true;
    }
}
