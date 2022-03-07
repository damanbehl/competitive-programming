package binary_trees.easy;

//https://leetcode.com/problems/diameter-of-binary-tree
import binary_trees.concept.BinaryTreeNode;
import binary_trees.concept.BinaryTreeUse;

public class DiameterBTree {
    static int diameter;

    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = BinaryTreeUse.takeInputLevelWise();
        BinaryTreeUse.printLevelWise(root);
        System.out.println(diameter(root));
    }

    public static int height(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return -1;
        }
        int ch = Math.max(height(root.left), height(root.right));

        return ch + 1;
    }

    public static int diameter(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return 0;
        }
        int option1 = height(root.left) + height(root.right) + 2;
        int option2 = diameter(root.left);
        int option3 = diameter(root.right);
        return Math.max(option1, Math.max(option2, option3));
    }
}
