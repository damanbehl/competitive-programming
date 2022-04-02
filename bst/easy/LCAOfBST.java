package bst.easy;

//https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
import binary_trees.concept.TreeNode;

public class LCAOfBST {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (root.val == p.val || root.val == q.val) {
            return root;
        }
        boolean isDivergent = false;
        while (!isDivergent) {
            if (p.val < root.val && q.val < root.val) {
                root = root.left;
            } else if (p.val > root.val && q.val > root.val) {
                root = root.right;
            } else {
                isDivergent = true;
            }
        }
        return root;
    }

    public TreeNode lowestCommonAncestorRecursive(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (root.val == p.val || root.val == q.val) {
            return root;
        }
        if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        } else if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else {
            TreeNode leftAns = lowestCommonAncestor(root.right, p, q);
            TreeNode rightAns = lowestCommonAncestor(root.left, p, q);
            if (leftAns == null) {
                return rightAns;
            }
            if (rightAns == null) {
                return leftAns;
            }
            return root;
        }
    }
}
