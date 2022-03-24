package bst.medium;

//https://leetcode.com/problems/delete-node-in-a-bst/
public class DeleteFromBST {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (key < root.val) {
            root.left = deleteNode(root.left, key);
            return root;
        } else if (key > root.val) {
            root.right = deleteNode(root.right, key);
            return root;
        } else {
            if (root.left == null && root.right == null) {
                return null;
            } else if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            } else {
                TreeNode subRoot = root.right;
                while (subRoot.left != null) {
                    subRoot = subRoot.left;
                }
                root.val = subRoot.val;
                // can use recursion to delete the replaced value from the right subtree
                // update the root since the value can be found immediately and then return
                // original root
                root.right = deleteNode(root.right, subRoot.val);
                return root;
            }
        }
    }
}
