package binary_trees.medium;

public class LCABetter {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return null;
        if (root.val == p.val || root.val == q.val) {
            return root;
        }
        TreeNode leftAns = lowestCommonAncestor(root.left, p, q);
        if (leftAns != null) {
            if (leftAns.val != p.val && leftAns.val != q.val) {
                return leftAns;
            }
        }
        TreeNode rightAns = lowestCommonAncestor(root.right, p, q);
        if (leftAns == null || rightAns == null)
            return leftAns != null ? leftAns : rightAns;
        return root;
    }
}
