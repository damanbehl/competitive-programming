package binary_trees.medium;

import java.util.ArrayList;
/**
 * Problem statement:
 * Given a binary tree and an integer K, return two nodes which are at different level and their sum is equal to K.

Constraints :

    Tree can have duplicate values.
    Incase more than one pair is available in the tree, then return any of the pair.

 */
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import binary_trees.concept.TreeNode;

public class PairToXDiffLevel {
    public static void main(String[] args) {

    }

    // O(n)
    public static List<TreeNode> twoSumSingle(TreeNode root, int k) {
        HashMap<Integer, TreeNode> allLevels = new HashMap<>();
        Queue<TreeNode> pendingNodes = new LinkedList<>();
        pendingNodes.add(root);
        while (!pendingNodes.isEmpty()) {
            TreeNode front;
            HashMap<Integer, TreeNode> curLevel = new HashMap<>();
            for (int i = 0; i < pendingNodes.size(); i++) {
                front = pendingNodes.poll();
                if (allLevels.containsKey(k - front.val)) {
                    List<TreeNode> ret = new ArrayList<TreeNode>();
                    ret.add(front);
                    ret.add(allLevels.get(k - front.val));
                    return ret;
                }
                if (front.left != null)
                    pendingNodes.add(front.left);
                if (front.right != null)
                    pendingNodes.add(front.right);
                curLevel.put(front.val, front);
            }
            allLevels.putAll(curLevel);
        }
        // did not find such a pair
        return new ArrayList<TreeNode>();
    }
}
