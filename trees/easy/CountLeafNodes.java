package trees.easy;

import trees.concept.TreeNode;
import trees.concept.TreeUseLevelWise;

public class CountLeafNodes {
    public static void main(String[] args) {
        TreeNode<Integer> root = TreeUseLevelWise.takeInput();
        int noOfLeafNodes = countLeaves(root);
        System.out.println("The number if leaf nodes is" + noOfLeafNodes);
    }

    public static int countLeaves(TreeNode<Integer> root) {
        if (root == null) {
            return 0;
        }
        if (root.children.size() == 0) {
            return 1;
        }
        int total = 0;
        for (TreeNode<Integer> child : root.children) {
            total += countLeaves(child);
        }
        return total;
    }
}
