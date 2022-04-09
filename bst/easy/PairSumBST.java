package bst.easy;

//https://leetcode.com/problems/two-sum-iv-input-is-a-bst
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

import binary_trees.concept.TreeNode;

public class PairSumBST {
    public boolean findTarget(TreeNode root, int k) {
        HashMap<Integer, TreeNode> hm = new HashMap<>();
        Queue<TreeNode> pendingNodes = new LinkedList<>();
        pendingNodes.add(root);
        while (!pendingNodes.isEmpty()) {
            TreeNode front = pendingNodes.poll();
            if (hm.containsKey(k - front.val)) {
                return true;
            } else {
                hm.put(front.val, front);
            }
            if (front.left != null)
                pendingNodes.add(front.left);
            if (front.right != null)
                pendingNodes.add(front.right);
        }
        return false;
    }

    // find Target better sample 1ms sol
    // find smallest left child and check if the remaining value is greater than the
    // left most node,if yes, find the remaining value in the whole tree
    // else the leftmo
    static boolean isPresent;

    public static boolean findTargetBetter(TreeNode root, int k) {
        isPresent = false;
        if (root.left == null && root.right == null) {
            return false;
        }
        findTargetBetterHelper(root, root, k);
        return isPresent;
    }

    public static void findTargetBetterHelper(TreeNode node, TreeNode root, int k) {
        if (node == null) {
            return;
        }
        findTargetBetterHelper(node.left, root, k);
        int rest = k - node.val;
        // rest>node.val condition check is required because if a case arises
        // where k =root.val*2
        // then find(k-root.val) will be the node itself and will return true even when
        // it should not
        // example case is (2 L null R 3) and k = 6
        if (rest > node.val) {
            if (find(root, rest)) {
                isPresent = true;
                return;
            }
        }
        findTargetBetterHelper(node.right, root, k);
    }

    public static boolean find(TreeNode root, int k) {
        if (root == null) {
            return false;
        }
        if (root.val == k) {
            return true;
        }
        if (root.val < k) {
            return find(root.right, k);
        } else {
            return find(root.left, k);
        }
    }
}
