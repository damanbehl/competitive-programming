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
                TreeNode prevToSub = root.right;
                while (subRoot.left != null) {
                    prevToSub = subRoot;
                    subRoot = subRoot.left;
                }
                if (subRoot.right != null && subRoot != prevToSub) {
                    prevToSub.left = subRoot.right;
                } else {
                    prevToSub.left = null;
                }
                if (subRoot != prevToSub) {
                    subRoot.right = root.right;
                }
                subRoot.left = root.left;
                return subRoot;
            }
        }
    }
}
