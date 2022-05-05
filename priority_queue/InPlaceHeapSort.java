package priority_queue;

//https://leetcode.com/problems/sort-an-array
public class InPlaceHeapSort {
    public static void main(String[] args) {
        int arr[] = { 5, 1, 9, 2, 0, 6 };
        for (int i = 0; i < arr.length; i++) {
            insertInVirtualHeap(arr, i);
        }
        for (int i = 0; i < arr.length; i++) {
            arr[arr.length - i - 1] = removeMinFromVirtualHeap(arr, arr.length - i);
        }
        for (int x : arr) {
            System.out.print(x + " ");
        }
    }

    // simulate heap
    public static void insertInVirtualHeap(int arr[], int i) {
        if (arr.length == 0) {
            return;
        }
        int childIndex = i;
        int parentIndex = (childIndex - 1) / 2;
        while (childIndex > 0) {
            if (arr[childIndex] < arr[parentIndex]) {
                int temp = arr[childIndex];
                arr[childIndex] = arr[parentIndex];
                arr[parentIndex] = temp;
                childIndex = parentIndex;
                parentIndex = (childIndex - 1) / 2;
            } else {
                break;
            }
        }
    }
    // SINGLE SHOT
    // public void insertInVirtualHeap(int arr[]) {
    // if (arr.length == 0) {
    // return;
    // }
    // for (int i = 0; i < arr.length; i++) {
    // int index = i;
    // int parentIndex;
    // while (index > 0) {
    // parentIndex = (index - 1) / 2;
    // if (arr[index] > arr[parentIndex]) {
    // int temp = arr[index];
    // arr[index] = arr[parentIndex];
    // arr[parentIndex] = temp;
    // index = parentIndex;
    // } else {
    // break;
    // }
    // }
    // }
    // }

    public static int removeMinFromVirtualHeap(int arr[], int size) {
        int min = arr[0];
        arr[0] = arr[size - 1];
        size--;
        int index = 0;
        int minIndex = index;
        int lChildIndex, rChildIndex;
        while (index < size - 1) {
            lChildIndex = 2 * index + 1;
            rChildIndex = 2 * index + 2;
            if (lChildIndex < size && arr[lChildIndex] < arr[minIndex]) {
                minIndex = lChildIndex;
            }
            if (rChildIndex < size && arr[rChildIndex] < arr[minIndex]) {
                minIndex = rChildIndex;
            }
            if (minIndex == index) {
                break;
            } else {
                int temp = arr[index];
                arr[index] = arr[minIndex];
                arr[minIndex] = temp;
                index = minIndex;
            }
        }
        return min;
    }

    // public static int inPlaceHeapSortRemove(int arr[]) {
    // if (arr.length == 0) {
    // return -1;
    // }
    // int min = arr[0];
    // arr[0] = arr[arr.length - 1];
    // arr[arr.length - 1] = min;
    // }
}
