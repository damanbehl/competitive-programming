package binary_trees.medium;

//https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        return getLCA(root, p, q);
    }

    public static TreeNode getLCA(TreeNode root, TreeNode p,
            TreeNode q) {
        if (root == null) {
            return null;
        }
        return getLCAHelper(root, p, q).node;
    }

    public static Helper getLCAHelper(TreeNode root,
            TreeNode p,
            TreeNode q) {
        Helper res = new Helper(false, false, null, 0);
        if (root == null) {
            return res;
        }
        if (root.val == p.val || root.val == q.val) {
            if (root.val == p.val) {
                res.pres = true;
            } else {
                res.qres = true;
            }
        }
        Helper leftAns = getLCAHelper(root.left, p, q);
        // improvement one, no duplicate nodes means we can terminate our search if
        // value is found
        if (leftAns.pres && leftAns.qres) {
            return leftAns;
        }
        Helper rightAns = getLCAHelper(root.right, p, q);
        res.pres = res.pres || leftAns.pres || rightAns.pres;
        res.qres = res.qres || leftAns.qres || rightAns.qres;
        res.height = Math.max(leftAns.height, rightAns.height) + 1;
        res.node = root;
        if ((leftAns.pres && leftAns.qres) && (rightAns.pres && rightAns.qres)) {
            return leftAns.height < rightAns.height ? leftAns : rightAns;
        } else if (leftAns.pres && leftAns.qres) {
            return leftAns;
        } else if (rightAns.pres && rightAns.qres) {
            return rightAns;
        }
        return res;

    }
}

class Helper {
    boolean pres;
    boolean qres;
    TreeNode node;
    int height;

    public Helper(boolean pres, boolean qres, TreeNode node, int height) {
        this.pres = pres;
        this.qres = qres;
        this.node = node;
        this.height = 0;
    }
}
