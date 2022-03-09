package binary_trees.medium;

//https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
import binary_trees.concept.BinaryTreeNode;
import binary_trees.concept.BinaryTreeUse;

public class BTreeFromPostIn {
    public static void main(String[] args) {
        int postOrder[] = { 4, 5, 2, 6, 7, 3, 1 };
        int inOrder[] = { 4, 2, 5, 1, 6, 3, 7 };
        BinaryTreeNode<Integer> root = treeFromPostIn(inOrder, postOrder);
        BinaryTreeUse.printLevelWise(root);
    }

    public static BinaryTreeNode<Integer> treeFromPostIn(int inOrder[], int postOrder[]) {
        return treeFromPostInHelper(inOrder, postOrder, 0, inOrder.length - 1, 0, postOrder.length - 1);
    }

    public static BinaryTreeNode<Integer> treeFromPostInHelper(int inOrder[], int postOrder[], int inSI, int inEI,
            int postSI, int postEI) {
        if (inSI > inEI) {
            return null;
        }
        BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(postOrder[postEI]);
        int match = -1;
        for (int i = inSI; i <= inEI; i++) {
            if (inOrder[i] == postOrder[postEI]) {
                match = i;
                break;
            }
        }
        // NOERS: number of elements on right sub-tree
        int NOERS = inEI - match;
        root.left = treeFromPostInHelper(inOrder, postOrder, inSI, match - 1, postSI, postEI - NOERS - 1);
        root.right = treeFromPostInHelper(inOrder, postOrder, match + 1, inEI, postEI - NOERS, postEI - 1);
        return root;
    }
}
