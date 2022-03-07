package generic_tree.easy;

import generic_tree.concept.TreeNode;
import generic_tree.concept.TreeUseLevelWise;

public class SumOfAllNodes {
    public static void main(String[] args) {
        TreeNode<Integer> root = TreeUseLevelWise.takeInput();
        SumOfAllNodes ob = new SumOfAllNodes();
        System.out.println(ob.sumOfAllNodes(root));
    }

    public int sumOfAllNodes(TreeNode<Integer> root) {
        if (root == null) {
            return 0;
        }
        int sum = root.data;
        for (int i = 0; i < root.children.size(); i++) {
            sum += sumOfAllNodes(root.children.get(i));
        }
        return sum;
    }
}
