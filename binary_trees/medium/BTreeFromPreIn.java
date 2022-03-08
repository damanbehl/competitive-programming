package binary_trees.medium;

import binary_trees.concept.BinaryTreeNode;
import binary_trees.concept.BinaryTreeUse;

public class BTreeFromPreIn {
    public static void main(String[] args) {
        int preOrder[] = { 1, 2, 4, 5, 3, 6, 7 };
        int inOrder[] = { 4, 2, 5, 1, 6, 3, 7 };
        BinaryTreeNode<Integer> root = treeFromPreAndIn(preOrder, inOrder);
        BinaryTreeUse.printLevelWise(root);

    }

    public static BinaryTreeNode<Integer> treeFromPreAndIn(int preOrder[], int inOrder[]) {
        return treeFromPreAndInHelper(preOrder, inOrder, 0, preOrder.length - 1, 0, inOrder.length - 1);
    }

    public static BinaryTreeNode<Integer> treeFromPreAndInHelper(int preOrder[], int inOrder[], int preSI, int preEI,
            int inSI, int inEI) {
        if (inSI > inEI) {
            return null;
        }
        BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(preOrder[preSI]);
        int match = -1;
        for (int i = inSI; i <= inEI; i++) {
            if (inOrder[i] == preOrder[preSI]) {
                match = i;
                break;
            }
        }
        // NumberOfElementsOnLeftSubtree
        int NOELS = match - inSI;
        root.left = treeFromPreAndInHelper(preOrder, inOrder, preSI + 1, preSI + NOELS, inSI, match - 1);
        root.right = treeFromPreAndInHelper(preOrder, inOrder, preSI + NOELS + 1, preEI, match + 1, inEI);
        return root;
    }
}
