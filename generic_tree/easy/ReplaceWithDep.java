package generic_tree.easy;

import generic_tree.concept.TreeNode;
import generic_tree.concept.TreeUseLevelWise;

public class ReplaceWithDep {
    public static void main(String[] args) {
        TreeNode<Integer> root = TreeUseLevelWise.takeInput();
        replaceNodesWithDepth(root, 0);
        TreeUseLevelWise.print_formatted(root);
    }

    public static void replaceNodesWithDepth(TreeNode<Integer> root, int x) {
        root.data = x;
        for (TreeNode<Integer> child : root.children) {
            replaceNodesWithDepth(child, x + 1);
        }
    }
}