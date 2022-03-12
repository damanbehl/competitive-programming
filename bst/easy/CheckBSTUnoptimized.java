package bst.easy;

import binary_trees.concept.BinaryTreeNode;
import binary_trees.concept.BinaryTreeUse;

public class CheckBSTUnoptimized {
    public static void main(String[] args) {

    }

    public static boolean isBST(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return true;
        }
        int leftMax = maximum(root.left);
        int rightMin = minimum(root.right);
        if (root.data <= leftMax || root.data > rightMin) {
            return false;
        }
        boolean isLeftBST = isBST(root.left);
        boolean isRightBST = isBST(root.right);
        return isLeftBST && isRightBST;
    }

    public static int maximum(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }
        return Math.max(root.data, Math.max(maximum(root.left), maximum(root.right)));
    }

    public static int minimum(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return Integer.MAX_VALUE;
        }
        return Math.min(root.data, Math.min(minimum(root.left), minimum(root.right)));
    }
}
