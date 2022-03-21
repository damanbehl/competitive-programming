package binary_trees.medium;

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

}
