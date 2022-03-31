package binary_trees.easy;

/**
 * Problem Description: ####Given a Binary Tree with N number of nodes, for each node create 
 * a new duplicate node, and insert that duplicate as left child of the original node.
 */
import binary_trees.concept.BinaryTreeUse;
import binary_trees.concept.BinaryTreeNode;

public class DoubleTree {
    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = BinaryTreeUse.takeInputLevelWise();
        BinaryTreeUse.printLevelWise(root);
        duplicateLeftNodes(root);
        BinaryTreeUse.printLevelWise(root);
    }

    public static void duplicateLeftNodes(BinaryTreeNode<Integer> root) {
        if (root == null)
            return;
        BinaryTreeNode<Integer> left = root.left;
        root.left = new BinaryTreeNode<Integer>(root.data);
        root.left.left = left;
        // root.left.right = null;
        duplicateLeftNodes(left);
        duplicateLeftNodes(root.right);
    }
}
