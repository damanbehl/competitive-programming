package bst.medium;

//https://practice.geeksforgeeks.org/problems/largest-bst
//https://www.codingninjas.com/codestudio/problems/largest-bst-subtree_893103
public class LargestBSTInBT {
    static int largestBst(TreeNode root) {
        // Write your code here

        return lBSTHelper(root).maxSize;
    }

    static cNode lBSTHelper(TreeNode root) {
        if (root == null) {
            return new cNode(Integer.MIN_VALUE, Integer.MAX_VALUE, 0);
        }
        cNode left = lBSTHelper(root.left);
        cNode right = lBSTHelper(root.right);
        if (left.max < root.val && root.val < right.min) {
            return new cNode(Math.max(root.val, right.max), Math.min(root.val, left.min),
                    left.maxSize + right.maxSize + 1);
        }
        return new cNode(Integer.MAX_VALUE, Integer.MIN_VALUE, Math.max(left.maxSize, right.maxSize));
    }

    static class cNode {
        int max;
        int min;
        int maxSize;

        cNode(int max, int min, int maxSize) {
            this.max = max;
            this.min = min;
            this.maxSize = maxSize;
        }
    }
}