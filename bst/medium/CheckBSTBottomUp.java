package bst.medium;

//https://practice.geeksforgeeks.org/problems/check-for-bst/1/
import binary_trees.concept.BinaryTreeNode;
import binary_trees.concept.BinaryTreeUse;
import utility.Pair;

/**
 * will fail for edge cases such as Integer.MIN_VALUE or Integer.MAX_VALUE at
 * leaf nodes
 */
public class CheckBSTBottomUp {
    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = BinaryTreeUse.takeInputLevelWise();
        BinaryTreeUse.printLevelWise(root);
        System.out.println(isBST(root));
    }

    public static boolean isBST(BinaryTreeNode<Integer> root) {
        return isBSTHelper(root).first;
    }

    public static Pair<Boolean, Pair<Integer, Integer>> isBSTHelper(BinaryTreeNode<Integer> root) {
        Pair<Boolean, Pair<Integer, Integer>> unitPair = new Pair<>();
        unitPair.second = new Pair<Integer, Integer>();
        if (root == null) {
            unitPair.first = true;
            unitPair.second.first = Integer.MIN_VALUE;
            unitPair.second.second = Integer.MAX_VALUE;
            return unitPair;
        }
        Pair<Boolean, Pair<Integer, Integer>> smallAnsLeft = isBSTHelper(root.left);
        Pair<Boolean, Pair<Integer, Integer>> smallAnsRight = isBSTHelper(root.right);
        if (!smallAnsLeft.first || !smallAnsRight.first || root.data <= smallAnsLeft.second.first
                || root.data > smallAnsRight.second.second) {
            unitPair.first = false;
            return unitPair;
        }
        unitPair.first = true;
        unitPair.second.first = Math.max(root.data, Math.max(smallAnsLeft.second.first, smallAnsRight.second.first));
        unitPair.second.second = Math.min(root.data, Math.min(smallAnsRight.second.second, smallAnsLeft.second.second));
        return unitPair;
    }
}
