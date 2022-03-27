package bst.avl.medium;

//https://leetcode.com/problems/balance-a-binary-search-tree/
import java.util.LinkedList;
import java.util.Queue;

import binary_trees.concept.TreeNode;

public class BalanceABST {
    public TreeNode balanceBST(TreeNode root) {
        MTreeNode modRoot = null;
        Queue<TreeNode> pendingNodes = new LinkedList<>();
        pendingNodes.add(root);
        while (!pendingNodes.isEmpty()) {
            TreeNode front = pendingNodes.poll();
            modRoot = addData(modRoot, front.val);
            if (front.left != null) {
                pendingNodes.add(front.left);
            }
            if (front.right != null) {
                pendingNodes.add(front.right);
            }
        }
        TreeNode result = convertAVLNodesToTreeNodes(modRoot);
        return result;

    }

    public static TreeNode convertAVLNodesToTreeNodes(MTreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode result = new TreeNode(root.val);
        result.left = convertAVLNodesToTreeNodes(root.left);
        result.right = convertAVLNodesToTreeNodes(root.right);
        return result;
    }

    public static MTreeNode addData(MTreeNode root, int data) {
        if (root == null) {
            return new MTreeNode(data);
        }
        if (data < root.val) {
            root.left = addData(root.left, data);
        } else if (data > root.val) {
            root.right = addData(root.right, data);
        }
        // check for rotation
        return getRotation(root);
    }

    public static MTreeNode getRotation(MTreeNode root) {
        updateHeightBalance(root);
        if (root.balance == 2) {
            if (root.left.balance == 1) {
                // LL
                return rotateRight(root);
            } else {
                // LR
                root.left = rotateLeft(root.left);
                return rotateRight(root);
            }
        } else if (root.balance == -2) {
            if (root.right.balance == -1) {
                // RR
                return rotateLeft(root);
            } else {
                // RL
                root.right = rotateRight(root.right);
                return rotateLeft(root);
            }
        }
        return root;
    }

    public static MTreeNode rotateLeft(MTreeNode A) {
        MTreeNode B = A.right;
        MTreeNode bLeft = B.left;
        B.left = A;
        A.right = bLeft;

        updateHeightBalance(A);
        updateHeightBalance(B);
        return B;
    }

    public static MTreeNode rotateRight(MTreeNode A) {
        MTreeNode B = A.left;
        MTreeNode bRight = B.right;
        B.right = A;
        A.left = bRight;

        updateHeightBalance(A);
        updateHeightBalance(B);
        return B;
    }

    public static void updateHeightBalance(MTreeNode root) {
        int lh = -1;
        int rh = -1;
        if (root.left != null) {
            lh = root.left.height;
        }
        if (root.right != null) {
            rh = root.right.height;
        }
        root.balance = lh - rh;
        root.height = Math.max(lh, rh) + 1;
    }

    public static class MTreeNode {
        public int val;
        public int balance = 0;
        public int height = 0;
        public MTreeNode left = null;
        public MTreeNode right = null;

        public MTreeNode(int val) {
            this.val = val;
        }
    }
}
