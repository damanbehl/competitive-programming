package generic_tree.concept;

import generic_tree.concept.TreeNode;
import generic_tree.concept.TreeUseLevelWise;

public class Traversal {
    public static void main(String[] args) {
        TreeNode<Integer> root = TreeUseLevelWise.takeInput();
        TreeUseLevelWise.print_formatted(root);
        preOrder(root);
        System.out.println("following is post order \t");
        postOrder(root);
    }

    public static void preOrder(TreeNode<Integer> root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        for (int i = 0; i < root.children.size(); i++) {
            preOrder(root.children.get(i));
        }
    }

    public static void postOrder(TreeNode<Integer> root) {
        if (root == null) {
            return;
        }
        for (int i = 0; i < root.children.size(); i++) {
            postOrder(root.children.get(i));
        }
        System.out.print(root.data + " ");
    }
}
