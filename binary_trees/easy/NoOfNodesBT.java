package binary_trees.easy;

import binary_trees.concept.BinaryTreeUse;
import binary_trees.concept.BinaryTreeNode;

public class NoOfNodesBT {
    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = BinaryTreeUse.takeInputLevelWise();
        BinaryTreeUse.printLevelWise(root);
        // System.out.println(countNoOfNodes(root));
    }

    public static int countNoOfNodes(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return 0;
        }
        int total = 1;
        total += countNoOfNodes(root.left);
        total += countNoOfNodes(root.right);
        return total;
    }
}
