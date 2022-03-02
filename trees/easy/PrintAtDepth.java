package trees.easy;

import trees.concept.TreeNode;
import trees.concept.TreeUseLevelWise;

public class PrintAtDepth {
    public static void main(String[] args) {
        TreeNode<Integer> root = TreeUseLevelWise.takeInput();
        printNodesAtDepthK(root, 2);
    }

    static void printNodesAtDepthK(TreeNode<Integer> root, int depth) {
        if (depth == 0) {
            System.out.print(root.data + " ,");
            return;
        }
        for (int i = 0; i < root.children.size(); i++) {
            printNodesAtDepthK(root.children.get(i), depth - 1);
        }
    }
}
