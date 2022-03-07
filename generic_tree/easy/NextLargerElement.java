package generic_tree.easy;

import java.util.Scanner;

import generic_tree.concept.TreeNode;
import generic_tree.concept.TreeUseLevelWise;

public class NextLargerElement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        TreeNode<Integer> treeOne = TreeUseLevelWise.takeInput();
        TreeNode<Integer> larger = nextLargerElement(treeOne, x);
        if (larger != null) {
            System.out.println(larger.data);
        }
    }

    public static TreeNode<Integer> nextLargerElement(TreeNode<Integer> root, int x) {
        TreeNode<Integer> currentNGR = null;
        if (root.data > x) {
            currentNGR = root;
        }
        for (int i = 0; i < root.children.size(); i++) {
            TreeNode<Integer> smallAns = nextLargerElement(root.children.get(i), x);
            if (smallAns != null) {
                if (currentNGR != null && smallAns.data < currentNGR.data) {
                    currentNGR = smallAns;
                } else if (currentNGR == null) {
                    currentNGR = smallAns;
                }
            }
        }
        return currentNGR;
    }
}
