package binary_trees.easy;

import binary_trees.concept.BinaryTreeNode;
import binary_trees.concept.BinaryTreeUse;

public class SumNodesBTree {
    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = BinaryTreeUse.takeInputLevelWise();
        System.out.println(sumOfAllNodes(root));
    }

    public static int sumOfAllNodes(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return 0;
        }
        int sum = root.data;
        sum += sumOfAllNodes(root.left);
        sum += sumOfAllNodes(root.right);
        return sum;
    }
}
