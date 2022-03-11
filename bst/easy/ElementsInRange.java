package bst.easy;

import java.util.ArrayList;

import binary_trees.concept.BinaryTreeNode;

public class ElementsInRange {
    public static ArrayList<Integer> printNearNodes(BinaryTreeNode<Integer> root, int low, int high) {
        // code here.
        ArrayList<Integer> result = new ArrayList<>();
        printNearNodesHelper(root, low, high, result);
        return result;
    }

    public static void printNearNodesHelper(BinaryTreeNode<Integer> root, int low, int high,
            ArrayList<Integer> result) {
        if (root == null) {
            return;
        }
        if (root.data <= high && root.data >= low) {
            printNearNodesHelper(root.left, low, high, result);
            result.add(root.data);
            printNearNodesHelper(root.right, low, high, result);
        } else if (root.data < high) {
            printNearNodesHelper(root.right, low, high, result);
        } else {
            printNearNodesHelper(root.left, low, high, result);
        }
    }
}
