package recursion.easy;

public class BinarySearchRecursive {
    public static void main(String[] args) {

    }

    public static int binarySearch(int[] arr, int x) {
        return binarySearchRecursive(arr, 0, arr.length - 1, x);
    }

    static int binarySearchRecursive(int arr[], int l, int r, int query) {
        if (l >= r) {
            return -1;
        }
        int m = (l + r) / 2;
        if (arr[m] == query) {
            return m;
        } else if (arr[m] > query) {
            return binarySearchRecursive(arr, l, m - 1, query);
        } else {
            return binarySearchRecursive(arr, m + 1, r, query);
        }
    }
}
