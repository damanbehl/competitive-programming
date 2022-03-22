package binary_trees.medium;

//https://leetcode.com/problems/flatten-binary-tree-to-linked-list
import java.util.Stack;

// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class FlattenABT {
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode currentNode = stack.pop();
            if (currentNode.right != null) {
                stack.push(currentNode.right);
            }
            if (currentNode.left != null) {
                stack.push(currentNode.left);
            }
            if (!stack.isEmpty()) {
                currentNode.right = stack.peek();
            }
            currentNode.left = null;
        }
    }

    static TreeNode prev;
    // public void flatten(TreeNode root) {
    // if(root == null){
    // return;
    // }
    // prev = null;
    // flattenRecursive(root);
    // }

    /**
     * buidling from reverse (right, left, root) whilst carrying prev all along
     * 
     * @param root
     */
    public void flattenRecursive(TreeNode root) {
        if (root == null) {
            return;
        }
        flattenRecursive(root.right);
        flattenRecursive(root.left);
        root.right = prev;
        root.left = null;
        prev = root;
    }

    // flattening using morris traversal, the rightmost node of the left subtree's
    // preorder's right is connected to the right of the root(contextual) and then
    // we traverse onwards to each and every possible left tree on either side
    public void flattenMorrisTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode curr = root;
        while (curr != null) {
            if (curr.left != null) {
                TreeNode prev = curr.left;
                while (prev.right != null) {
                    prev = prev.right;
                }
                prev.right = curr.right;
                curr.right = curr.left;
                curr.left = null;
            }
            curr = curr.right;
        }
    }
}
