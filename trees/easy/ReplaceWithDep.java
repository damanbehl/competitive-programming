package trees.easy;

import trees.concept.TreeUseLevelWise;
import trees.concept.TreeNode;

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