package binary_trees.medium;

//https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/
import java.util.ArrayList;
import java.util.List;

public class NodesKAwayFromNode {
    static ArrayList<TreeNode> path;

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        path = new ArrayList<>();
        find(root, target);
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < path.size(); i++) {
            printKDown(path.get(i), k - i, i == 0 ? null : path.get(i - 1), result);
        }
        return result;
    }

    public static void printKDown(TreeNode root, int down, TreeNode blocker, List<Integer> result) {
        if (root == null || down < 0 || root == blocker) {
            return;
        }
        if (down == 0) {
            result.add(root.val);
        }
        printKDown(root.left, down - 1, blocker, result);
        printKDown(root.right, down - 1, blocker, result);
    }

    public static boolean find(TreeNode root, TreeNode target) {
        if (root == null)
            return false;
        if (root == target) {
            path.add(root);
            return true;
        }
        boolean leftAns = find(root.left, target);
        if (leftAns) {
            path.add(root);
            return true;
        }
        boolean rightAns = find(root.right, target);
        if (rightAns) {
            path.add(root);
            return true;
        }
        return false;
    }
}
