package recursion.easy;

import java.util.ArrayList;

public class allIndicesX {
    public static void main(String[] args) {
        int arr[] = new int[] { 1, 2, 3, 4, 2, 4, 2, 3, 2 };
        print(getAllIndices(arr, 2, 0, new ArrayList<Integer>()));
    }

    static ArrayList<Integer> getAllIndices(int arr[], int x, int index, ArrayList<Integer> results) {
        if (index >= arr.length) {
            return results;
        }
        if (arr[index] == x) {
            results.add(index);
        }
        return getAllIndices(arr, x, ++index, results);
    }

    static void print(ArrayList<Integer> toPrint) {
        for (int x : toPrint) {
            System.out.print(x + " ");
        }
    }
}
