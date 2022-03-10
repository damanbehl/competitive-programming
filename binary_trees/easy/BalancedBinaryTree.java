package binary_trees.easy;

//https://leetcode.com/problems/balanced-binary-tree
import binary_trees.concept.BinaryTreeUse;
import binary_trees.concept.BinaryTreeNode;

public class BalancedBinaryTree {
    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = BinaryTreeUse.takeInputLevelWise();
        System.out.println(isBalanced(root));
    }

    public static boolean isBalanced(BinaryTreeNode<Integer> root) {
        // return height(root).second;
        if (heightBetter(root) == -1) {
            return false;
        }
        return true;
    }

    public static PairTwo<Integer, Boolean> height(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return new PairTwo<Integer, Boolean>(-1, true);
        }
        PairTwo<Integer, Boolean> LST = height(root.left);
        PairTwo<Integer, Boolean> RST = height(root.right);
        int smallHeight = 1 + Math.max(LST.first, RST.first);
        Boolean second = LST.second && RST.second;
        if (LST.second != false && RST.second != false) {
            second = !(Math.abs(LST.first - RST.first) > 1);
        }
        return new PairTwo<Integer, Boolean>(smallHeight, second);
    }

    public static int heightBetter(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = heightBetter(root.left);
        int rightHeight = heightBetter(root.right);
        if (leftHeight == -1 || rightHeight == -1) {
            return -1;
        }
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }
        return 1 + Math.max(leftHeight, rightHeight);
    }
}

class PairTwo<T, V> {
    T first;
    V second;

    PairTwo(T first, V second) {
        this.first = first;
        this.second = second;
    }
}
