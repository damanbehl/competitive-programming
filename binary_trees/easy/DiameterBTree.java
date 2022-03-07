package binary_trees.easy;

//https://leetcode.com/problems/diameter-of-binary-tree
import binary_trees.concept.BinaryTreeNode;
import binary_trees.concept.BinaryTreeUse;

public class DiameterBTree {
    static int diameter;

    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = BinaryTreeUse.takeInputLevelWise();
        BinaryTreeUse.printLevelWise(root);
        System.out.println(diameterBetterUsingHeight(root));
    }

    public static int height(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return -1;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        int ch = Math.max(leftHeight, rightHeight);

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

    public int diameterOfBinaryTree(BinaryTreeNode<Integer> root) {
        diameter = 0;
        int height = diameterBetterUsingHeight(root);
        return diameter;
    }

    public static int diameterBetterUsingHeight(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return -1;
        }
        int leftChildHeight = diameterBetterUsingHeight(root.left);
        int rightChildHeight = diameterBetterUsingHeight(root.right);
        int candidate = leftChildHeight + rightChildHeight + 2;
        if (candidate > diameter) {
            diameter = candidate;
        }
        return Math.max(leftChildHeight, rightChildHeight) + 1;
    }

    public static Pair<Integer, Integer> diameterBottomUp(BinaryTreeNode<Integer> root) {
        if (root == null) {
            Pair<Integer, Integer> zero = new Pair<>();
            zero.first = -1;
            zero.second = 0;
            return zero;
        }
        Pair<Integer, Integer> leftHd = diameterBottomUp(root.left);
        Pair<Integer, Integer> rightHd = diameterBottomUp(root.right);
        // + 2 for the edges that connect the node for which we are recursing on the
        // left and the right sub tree
        int diameter = leftHd.first + rightHd.first + 2;
        int height = 1 + Math.max(leftHd.first, rightHd.first);
        Pair<Integer, Integer> currentPair = new Pair<>();
        currentPair.first = height;
        currentPair.second = Math.max(diameter, Math.max(leftHd.second, rightHd.second));
        return currentPair;
    }
}

class Pair<T, V> {
    T first;
    V second;
}