package bst.easy;

import binary_trees.concept.BinaryTreeNode;
import binary_trees.concept.BinaryTreeUse;

public class SearchInBST {
    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = BinaryTreeUse.takeInputLevelWise();
        BinaryTreeNode<Integer> returned = searchInBSTRetNode(root, 12);
        System.out.println(returned != null ? returned.data : "empty");
    }

    public static Boolean searchInBST(BinaryTreeNode<Integer> root, int x) {
        // Write your code here.
        if (root == null) {
            return false;
        }
        if (root.data == x) {
            return true;
        } else if (root.data > x) {
            return searchInBST(root.left, x);
        } else {
            return searchInBST(root.right, x);
        }
    }

    public static BinaryTreeNode<Integer> searchInBSTRetNode(BinaryTreeNode<Integer> root, int x) {
        // Write your code here.
        if (root == null) {
            return null;
        }
        if (root.data == x) {
            return root;
        } else if (root.data > x) {
            return searchInBSTRetNode(root.left, x);
        } else {
            return searchInBSTRetNode(root.right, x);
        }
    }
}
