package bst.avl.medium;

//https://leetcode.com/problems/balance-a-binary-search-tree
import java.util.ArrayList;
import java.util.List;

import binary_trees.concept.TreeNode;

public class BlanceABSTFaster {
    static List<Integer> allNodes;

    public TreeNode balanceBST(TreeNode root) {
        allNodes = new ArrayList<Integer>();
        inorder(root);
        return reconstruct(0, allNodes.size() - 1);
    }

    public static TreeNode reconstruct(int l, int r) {
        if (l > r) {
            return null;
        }
        int m = (l + r) / 2;
        TreeNode root = new TreeNode(allNodes.get(m));
        root.left = reconstruct(l, m - 1);
        root.right = reconstruct(m + 1, r);
        return root;
    }

    public static void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        allNodes.add(root.val);
        inorder(root.right);
    }
}
