package binary_trees.easy;

//https://leetcode.com/problems/invert-binary-tree/submissions/
//https://www.codingninjas.com/codestudio/problems/convert-binary-tree-to-mirror-tree_873140
public class MirrorBinaryTree {
    public static void main(String[] args) {

    }

    public static void mirrorTree(BinaryTreeNode<Integer> node) {
        // Write your code here.
        if (node == null) {
            return;
        }
        BinaryTreeNode<Integer> temp = node.left;
        node.left = node.right;
        node.right = temp;
        mirrorTree(node.left);
        mirrorTree(node.right);
    }
}
