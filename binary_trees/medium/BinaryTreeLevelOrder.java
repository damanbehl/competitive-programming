package binary_trees.medium;

//https://leetcode.com/problems/binary-tree-level-order-traversal/
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import binary_trees.concept.TreeNode;

public class BinaryTreeLevelOrder {
    public static void main(String[] args) {

    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null) {
            return new ArrayList<List<Integer>>();
        }
        Queue<TreeNode> pendingNodes = new LinkedList<>();
        pendingNodes.add(root);
        while (!pendingNodes.isEmpty()) {
            ArrayList<Integer> subLevel = new ArrayList<>();
            int n = pendingNodes.size();
            for (int i = 0; i < n; i++) {
                TreeNode front = pendingNodes.poll();
                if (front == null) {
                    continue;
                }
                subLevel.add(front.val);
                pendingNodes.add(front.left);
                pendingNodes.add(front.right);
            }
            if (subLevel.size() > 0)
                result.add(subLevel);
        }
        return result;
    }
}
