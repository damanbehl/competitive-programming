package binary_trees.easy;

//https://www.codingninjas.com/codestudio/problems/code-find-a-node_5682
public class IsNodePresent {
    public static boolean isNodePresent(BinaryTreeNode<Integer> root, int x) {
        // Your code goes here
        if (root == null) {
            return false;
        }
        if (root.data == x) {
            return true;
        }
        return isNodePresent(root.left, x) || isNodePresent(root.right, x);
    }
}
