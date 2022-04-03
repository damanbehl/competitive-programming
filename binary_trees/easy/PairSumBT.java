package binary_trees.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

import binary_trees.concept.BinaryTreeUse;
import utility.PrintArrayList;
import binary_trees.concept.BinaryTreeNode;

/**
 * Problem Description: ####Given a binary tree and an integer S, print all the
 * pair of nodes whose sum equals S.
 * #####Assume binary tree contains all unique elements.
 */
public class PairSumBT {
    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = BinaryTreeUse.takeInputLevelWise();
        PrintArrayList ob = new PrintArrayList();
        ob.printNested(getPair(root, 10));
    }

    static ArrayList<ArrayList<Integer>> getPair(BinaryTreeNode<Integer> root, int k) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        Queue<BinaryTreeNode<Integer>> pending_nodes = new LinkedList<>();
        HashMap<Integer, BinaryTreeNode<Integer>> allNodes = new HashMap<>();
        pending_nodes.add(root);
        while (!pending_nodes.isEmpty()) {
            BinaryTreeNode<Integer> front = pending_nodes.poll();
            if (allNodes.containsKey(k - front.data)) {
                ArrayList<Integer> subRes = new ArrayList<>();
                subRes.add(front.data);
                subRes.add(k - front.data);
                result.add(subRes);
            } else {
                allNodes.put(front.data, front);
            }
            if (front.left != null) {
                pending_nodes.add(front.left);
            }
            if (front.right != null) {
                pending_nodes.add(front.right);
            }
        }
        return result;
    }

}
