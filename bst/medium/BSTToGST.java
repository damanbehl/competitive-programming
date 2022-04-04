package bst.medium;

//https://leetcode.com/problems/binary-search-tree-to-greater-sum-tree/
public class BSTToGST {
    static int prevSum;

    public TreeNode bstToGst(TreeNode root) {
        prevSum = 0;
        bstToGstHelper(root);
        return root;
    }

    public void bstToGstHelper(TreeNode root) {
        if (root == null)
            return;
        bstToGstHelper(root.right);
        root.val = root.val + prevSum;
        prevSum = root.val;
        bstToGstHelper(root.left);
    }
}
