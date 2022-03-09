package binary_trees.medium;

//https://leetcode.com/problems/construct-binary-tree-from-preorder-and-postorder-traversal
import binary_trees.concept.BinaryTreeNode;
import binary_trees.concept.BinaryTreeUse;

public class BtreeFromPostPre {
    public static void main(String[] args) {
        int postOrder[] = { 4, 5, 2, 6, 7, 3, 1 };
        int preOrder[] = { 1, 2, 4, 5, 3, 6, 7 };
        BinaryTreeNode<Integer> root = treeFromPostPre(postOrder, preOrder);
        BinaryTreeUse.printLevelWise(root);
    }

    public static BinaryTreeNode<Integer> treeFromPostPre(int postOrder[], int preOrder[]) {
        return treeFromPostPreHelper(postOrder, preOrder, 0, preOrder.length - 1, 0, postOrder.length - 1);
    }

    public static BinaryTreeNode<Integer> treeFromPostPreHelper(int postOrder[], int preOrder[], int preSI, int preEI,
            int postSI, int postEI) {
        if (postSI > postEI) {
            return null;
        }
        BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(postOrder[postEI]);
        /**
         * GIST:
         * The difference with the generic method where we have inorder TRAV is that
         * since we are going to be checking one element back to the postEnding
         * index(or 1+prestarting index whatever you prefer)
         * (<this element>, <-- postEndingINDEX) or (prestartingindex,--> <thiselement>)
         * if the starting and ending indices are the same we do not have any more
         * elements to be process so we have return that element as node
         **/
        if (postEI == postSI) {
            return root;
        }
        int match = -1;
        for (int i = preSI; i <= preEI; i++) {
            if (postOrder[postEI - 1] == preOrder[i]) {
                match = i;
                break;
            }
        }
        int NOERS = preEI - match + 1;
        root.left = treeFromPostPreHelper(postOrder, preOrder, preSI + 1, match - 1, postSI, postEI - NOERS - 1);
        root.right = treeFromPostPreHelper(postOrder, preOrder, match, preEI, postEI - NOERS, postEI - 1);
        return root;
    }
}
