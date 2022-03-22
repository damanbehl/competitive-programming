package binary_trees.easy;

//https://leetcode.com/problems/binary-tree-paths/
import java.util.ArrayList;
import java.util.List;

// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<String>();
        binaryTreePathsHelper(root, "", result);
        return result;
    }

    public void binaryTreePathsHelper(TreeNode root, String pathTillNow, List<String> result) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            result.add(pathTillNow + root.val);
            return;
        }
        pathTillNow = pathTillNow + root.val + "->";
        binaryTreePathsHelper(root.left, pathTillNow, result);
        binaryTreePathsHelper(root.right, pathTillNow, result);
    }
}
