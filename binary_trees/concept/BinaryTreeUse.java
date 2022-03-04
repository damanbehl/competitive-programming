package binary_trees.concept;

import java.util.Scanner;

public class BinaryTreeUse {
    public static void main(String[] args) {
        // BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(2);
        // BinaryTreeNode<Integer> left = new BinaryTreeNode<Integer>(3);
        // BinaryTreeNode<Integer> right = new BinaryTreeNode<Integer>(4);
        // root.left = left;
        // root.right = right;
        // System.out.println(" empty");
        Scanner sc = new Scanner(System.in);
        BinaryTreeNode<Integer> root = takeInput(sc);
        printTree(root);
    }

    public static BinaryTreeNode<Integer> takeInput(Scanner sc) {
        System.out.println("Enter root");
        int data = sc.nextInt();
        if (data == -1) {
            return null;
        }
        BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(data);
        root.left = takeInput(sc);
        root.right = takeInput(sc);
        return root;
    }

    public static void printTree(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return;
        }
        String print = root.data + ": ";
        if (root.left != null) {
            print += "L>" + root.left.data + " ,";
        }
        if (root.left != null) {
            print += "R>" + root.right.data + " ,";
        }
        System.out.println(print);
        printTree(root.left);
        printTree(root.right);
    }
}
