package bst.easy;

//https://www.codingninjas.com/codestudio/problems/find-path-in-bst_5974
import java.util.ArrayList;

import binary_trees.concept.BinaryTreeNode;

public class PathInBST {

    public static ArrayList<Integer> getPath(BinaryTreeNode<Integer> root, int data) {
        if (root == null) {
            return null;
        }
        if (root.data == data) {
            ArrayList<Integer> unit = new ArrayList<>();
            unit.add(root.data);
            return unit;
        }
        if (root.data > data) {
            ArrayList<Integer> left = getPath(root.left, data);
            if (left != null) {
                left.add(root.data);
                return left;
            }
            return null;
        } else {
            ArrayList<Integer> right = getPath(root.right, data);
            if (right != null) {
                right.add(root.data);
                return right;
            }
            return null;
        }
    }
}
