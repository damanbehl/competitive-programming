package bst.medium;
// https://www.codingninjas.com/codestudio/problems/flatten-bst-to-a-sorted-list_1169459
import binary_trees.concept.BinaryTreeNode;
import binary_trees.concept.BinaryTreeUse;

public class BSTToSortedLL {

    static BinaryTreeNode<Integer> prev;

    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = BinaryTreeUse.takeInputLevelWise();
        BinaryTreeNode<Integer> newRoot = flatten(root);
        BinaryTreeUse.printLevelWise(newRoot);
    }

    public static BinaryTreeNode<Integer> flatten(BinaryTreeNode<Integer> root) {
        // Write your code here
        if (root == null) {
            return root;
        }
        prev = new BinaryTreeNode<Integer>(null);
        BinaryTreeNode<Integer> dummy = prev;
        flattenHelper(root);
        prev.left = null;
        prev.right = null;
        return dummy.right;
    }

    public static void flattenHelper(BinaryTreeNode<Integer> curr) {
        if (curr == null) {
            return;
        }
        flattenHelper(curr.left);
        prev.left = null;
        prev.right = curr;
        prev = curr;
        flattenHelper(curr.right);
    }
}