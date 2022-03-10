package binary_trees.easy;

//https://www.pepcoding.com/resources/online-java-foundation/binary-tree/remove-leaves-binary-tree-official/ojquestion
import binary_trees.concept.BinaryTreeNode;

public class RemoveLeaves {
    public static void main(String[] args) {

    }

    public static BinaryTreeNode<Integer> removeLeaves(BinaryTreeNode<Integer> root) {
        // write your code here
        if ((root == null) || (root.left == null && root.right == null)) {
            return null;
        }
        BinaryTreeNode<Integer> smallAns = removeLeaves(root.left);
        BinaryTreeNode<Integer> smallAnsRight = removeLeaves(root.right);
        root.left = smallAns;
        root.right = smallAnsRight;
        return root;
    }
}
