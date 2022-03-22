package bst.medium;

//https://www.codingninjas.com/codestudio/problems/bst-to-sorted-dll_1263694
import binary_trees.concept.BinaryTreeNode;

public class BSTToSortedDLL {
    static BinaryTreeNode<Integer> prev;

    public static BinaryTreeNode<Integer> bstToSortedDLL(BinaryTreeNode<Integer> root) {
        // Write your code here.
        if (root == null) {
            return null;
        }
        prev = new BinaryTreeNode<Integer>(null);
        BinaryTreeNode<Integer> dummy = prev;
        bstToSortedDLLHelper(root);
        prev.right = null;
        // prev.left = null;
        return dummy.right;
    }

    public static void bstToSortedDLLHelper(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return;
        }
        bstToSortedDLLHelper(root.left);
        prev.right = root;
        root.left = prev;
        prev = root;
        bstToSortedDLLHelper(root.right);
    }
}
