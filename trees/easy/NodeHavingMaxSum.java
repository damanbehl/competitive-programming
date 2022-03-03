package trees.easy;

import trees.concept.TreeNode;
import trees.concept.TreeUseLevelWise;

class Maximizer {
    public TreeNode<Integer> node;
    int sumOfselfandImmNodes;

    public Maximizer(TreeNode<Integer> node, int sumOfselfandImmNodes) {
        this.node = node;
        this.sumOfselfandImmNodes = sumOfselfandImmNodes;
    }
}

public class NodeHavingMaxSum {
    public static void main(String[] args) {
        TreeNode<Integer> root = TreeUseLevelWise.takeInput();
        Maximizer ans = maxSumNode(root);
        System.out.println(ans.node.data);
    }

    public static Maximizer maxSumNode(TreeNode<Integer> root) {
        if (root == null) {
            return null;
        }
        if (root.children.size() == 0) {
            return new Maximizer(null, 0);
        }
        int sum = root.data;
        for (TreeNode<Integer> node : root.children) {
            sum += node.data;
        }
        Maximizer maxCurrentNode = new Maximizer(root, sum);
        for (TreeNode<Integer> node : root.children) {
            Maximizer maxFromChildren = maxSumNode(node);
            if (maxFromChildren.sumOfselfandImmNodes > maxCurrentNode.sumOfselfandImmNodes) {
                maxCurrentNode = maxFromChildren;
            }
        }
        return maxCurrentNode;
    }
}
