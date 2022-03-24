package binary_trees.easy;

//https://www.codingninjas.com/codestudio/problems/path-in-a-tree_3843990
import java.util.ArrayList;

import binary_trees.concept.TreeNode;

// class TreeNode {
//     int data;
//     TreeNode left, right;

//     public TreeNode(int item) {
//         data = item;
//         left = right = null;
//     }
// }

public class RootToNodePath {
    public static ArrayList<Integer> pathInATree(TreeNode root, int x) {
        if (root == null) {
            return null;
        }
        if (root.val == x) {
            ArrayList<Integer> unit = new ArrayList<>();
            unit.add(root.val);
            return unit;
        }
        ArrayList<Integer> leftResult = pathInATree(root.left, x);
        if (leftResult != null) {
            leftResult.add(0, root.val);
            return leftResult;
        }
        ArrayList<Integer> rightResult = pathInATree(root.right, x);
        if (rightResult != null) {
            rightResult.add(0, root.val);
            return rightResult;
        }
        return null;
    }
}
