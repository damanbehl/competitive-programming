package utility;

import java.util.ArrayList;

import generic_tree.concept.TreeNode;

public class OutputALOfNodes {
    /**
     * To print to console comma seperated
     * 
     * @param list: List of TreeNode<Integer> nodes
     */
    public void print(ArrayList<TreeNode<Integer>> list) {
        for (TreeNode<Integer> element : list) {
            System.out.print(element.data + ", ");
        }
    }
}
