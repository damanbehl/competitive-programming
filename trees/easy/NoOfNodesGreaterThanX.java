package trees.easy;

import java.util.ArrayList;
import java.util.Scanner;

import trees.concept.TreeUseLevelWise;
import trees.concept.TreeNode;
import utility.OutputALOfNodes;

public class NoOfNodesGreaterThanX {
    public static void main(String[] args) {
        System.out.println("Enter the value of X");
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        TreeNode<Integer> root = TreeUseLevelWise.takeInput();

        ArrayList<TreeNode<Integer>> nodesGreaterThanX = new ArrayList<>();
        returnGreaterThanX(root, nodesGreaterThanX, x);
        OutputALOfNodes printer = new OutputALOfNodes();
        System.out.println("Nodes greater than x are:" + nodesGreaterThanX.size());
        printer.print(nodesGreaterThanX);
    }

    public static void returnGreaterThanX(TreeNode<Integer> root,
            ArrayList<TreeNode<Integer>> cache, int x) {
        if (root.data > x) {
            cache.add(root);
        }
        for (int i = 0; i < root.children.size(); i++) {
            returnGreaterThanX(root.children.get(i), cache, x);
        }
    }
}
