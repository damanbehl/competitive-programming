package binary_trees.medium;

//https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal
import binary_trees.concept.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ZigZagTrav {
    public static void main(String[] args) {

    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null) {
            return result;
        }
        boolean flip = false;
        LinkedList<TreeNode> pendingNodes = new LinkedList<>();
        pendingNodes.add(root);
        while (!pendingNodes.isEmpty()) {
            ArrayList<Integer> subLevel = new ArrayList<Integer>();
            int n = pendingNodes.size();
            for (int i = 0; i < n; i++) {
                TreeNode current;
                if (flip) {
                    current = pendingNodes.pollLast();
                    if (current == null) {
                        continue;
                    }
                    pendingNodes.addFirst(current.right);
                    pendingNodes.addFirst(current.left);
                } else {
                    current = pendingNodes.pollFirst();
                    if (current == null) {
                        continue;
                    }
                    pendingNodes.addLast(current.left);
                    pendingNodes.addLast(current.right);
                }
                subLevel.add(current.val);
            }
            flip = !flip;
            if (subLevel.size() > 0)
                result.add(subLevel);
        }
        return result;
    }
}
