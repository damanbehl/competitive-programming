package recursion.super_easy;

public class CheckIfSorted {
    public static void main(String[] args) {
        System.out.println(checkIfSortedBetter(new int[] { 0 }, 0));
    }

    static boolean checkIfSorted(int arr[]) {
        if (arr.length == 1 || arr.length == 0) {
            return true;
        }
        if (arr[0] > arr[1]) {
            return false;
        }
        int smallArr[] = new int[arr.length - 1];
        for (int i = 1; i < arr.length; i++) {
            smallArr[i - 1] = arr[i];
        }
        return checkIfSorted(smallArr);
    }

    static boolean checkIfSortedBetter(int arr[], int si) {
        if (si == arr.length - 1) {
            return true;
        }
        if (arr[si] > arr[si + 1]) {
            return false;
        }
        return checkIfSortedBetter(arr, si + 1);
    }
}