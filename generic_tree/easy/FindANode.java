package generic_tree.easy;

import generic_tree.concept.TreeNode;

public class FindANode {
    public static boolean find(TreeNode<Integer> node, int data) {
        // write your code here
        boolean flag = false;
        if (node.data == data) {
            return true;
        }
        for (TreeNode<Integer> child : node.children) {
            flag = find(child, data);
            if (flag == true) {
                return true;
            }
        }
        return flag;
    }
}
