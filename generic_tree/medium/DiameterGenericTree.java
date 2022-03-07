package generic_tree.medium;

import generic_tree.concept.TreeNode;
import generic_tree.concept.TreeUseLevelWise;

public class DiameterGenericTree {
    static int diameter = 0;

    public static void main(String[] args) {
        TreeNode<Integer> root = TreeUseLevelWise.takeInput();
        int height = calculateHtUlteriorMotive(root);
        System.out.println(diameter);
    }

    // calculating height with an ulterior motive for updating diameter for
    // wherever in the tree (whether a particular child node or via the root node)
    // the longest distance
    // between any two nodes exists.
    // o(n) as we are doing constant work for n nodes
    public static int calculateHtUlteriorMotive(TreeNode<Integer> root) {
        int dch = -1;
        int sdch = -1;
        for (int i = 0; i < root.children.size(); i++) {
            int ch = calculateHtUlteriorMotive(root.children.get(i));
            if (ch > dch) {
                sdch = dch;
                dch = ch;
            } else if (ch > sdch) {
                sdch = ch;
            }
            int candidate = dch + sdch + 2;
            if (candidate > diameter) {
                diameter = candidate;
            }
        }
        return dch + 1;
    }
}
