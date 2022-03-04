package trees.easy;

import trees.concept.TreeNode;
import trees.concept.TreeUseLevelWise;

class NodePair {
    TreeNode<Integer> largest;
    TreeNode<Integer> secondLargest;

    NodePair(TreeNode<Integer> largest, TreeNode<Integer> secondLargest) {
        this.largest = largest;
        this.secondLargest = secondLargest;
    }
}

public class SecondLargestnary {
    public static void main(String[] args) {
        TreeNode<Integer> treeOne = TreeUseLevelWise.takeInput();
        System.out.println(getSecondLargestNode(treeOne).secondLargest.data);
    }

    public static NodePair getSecondLargestNode(TreeNode<Integer> root) {
        TreeNode<Integer> largest = new TreeNode<Integer>(Integer.MIN_VALUE);
        TreeNode<Integer> secondLargest = largest;
        NodePair result = new NodePair(largest, secondLargest);
        getSecondLargestNodeHelper(root, result);
        return result;
    }

    public static void getSecondLargestNodeHelper(TreeNode<Integer> root, NodePair result) {
        if (root.data > result.largest.data) {
            result.secondLargest = result.largest;
            result.largest = root;
        } else if (root.data > result.secondLargest.data && root.data != result.largest.data) {
            result.secondLargest = root;
        }
        for (TreeNode<Integer> node : root.children) {
            getSecondLargestNodeHelper(node, result);
        }
    }
}
