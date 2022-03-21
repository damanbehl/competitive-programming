package bst.easy;

import java.util.ArrayList;
import binary_trees.concept.BinaryTreeNode;

public class BSTFromSortedArr {
    public static BinaryTreeNode<Integer> sortedArrToBST(ArrayList<Integer> arr, int n) {
        // Write your code here.
        return sortedArrToBSTHelper(arr, 0, n - 1);
    }

    public static BinaryTreeNode<Integer> sortedArrToBSTHelper(ArrayList<Integer> arr, int si, int ei) {
        if (si > ei) {
            return null;
        }
        int mid = si + ((ei - si) / 2);
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(arr.get(mid));
        root.left = sortedArrToBSTHelper(arr, si, mid - 1);
        root.right = sortedArrToBSTHelper(arr, mid + 1, ei);
        return root;
    }
}
