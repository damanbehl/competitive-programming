package binary_trees.easy;

//https://www.codingninjas.com/codestudio/problems/nodes-without-siblings_975485
import java.util.ArrayList;
import binary_trees.concept.BinaryTreeNode;
import binary_trees.concept.BinaryTreeUse;
import utility.PrintArrayList;

public class NodesWithoutSiblings {
    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = BinaryTreeUse.takeInputLevelWise();
        ArrayList<Integer> result = nodesWithoutSiblings(root);
        BinaryTreeUse.printLevelWise(root);
        PrintArrayList printer = new PrintArrayList();
        printer.print(result);
    }

    public static ArrayList<Integer> nodesWithoutSiblings(BinaryTreeNode<Integer> root) {
        // WRITE YOUR CODE HERE
        ArrayList<Integer> result = new ArrayList<>();
        nodesWithoutSiblingsHelper(root, result);
        return result;
    }

    public static void nodesWithoutSiblingsHelper(BinaryTreeNode<Integer> root, ArrayList<Integer> result) {
        // WRITE YOUR CODE HERE
        if (root == null) {
            return;
        }
        // System.out.println("recursing through " + root.data);
        if (root.left == null && root.right != null) {
            result.add(root.right.data);
        }
        if (root.left != null && root.right == null) {
            result.add(root.left.data);
        }
        nodesWithoutSiblingsHelper(root.left, result);
        nodesWithoutSiblingsHelper(root.right, result);
    }
}
