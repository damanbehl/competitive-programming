package bst.medium;

//https://leetcode.com/problems/validate-binary-search-tree
import binary_trees.concept.BinaryTreeNode;
import binary_trees.concept.BinaryTreeUse;

public class CheckBSTTopDown {
    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = BinaryTreeUse.takeInputLevelWise();
        BinaryTreeUse.printLevelWise(root);
        System.out.println(isBST(root));
    }

    public static boolean isBST(BinaryTreeNode<Integer> root) {
        return isBSTHelper(root, Integer.MAX_VALUE, Integer.MIN_VALUE);
    }

    public static boolean isBSTHelper(BinaryTreeNode<Integer> root, int max, int min) {
        if (root == null) {
            return true;
        }
        if (root.data < min || root.data > max) {
            return false;
        }
        if (root.data == Integer.MAX_VALUE) {
            if (root.right != null) {
                return false;
            }
        }
        if (root.data == Integer.MIN_VALUE) {
            if (root.left != null) {
                return false;
            }
        }
        return isBSTHelper(root.left, root.data - 1, min) && isBSTHelper(root.right, max, root.data + 1);
    }
}
