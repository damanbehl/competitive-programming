package trees.concept;

import java.util.Scanner;

public class TreeUse {
    public static TreeNode<Integer> takeInput(Scanner sc) {
        System.out.println("Enter the data for current root ");
        int data = sc.nextInt();
        TreeNode<Integer> root = new TreeNode<Integer>(data);
        System.out.println("Enter number of children for " + data);
        int children = sc.nextInt();
        for (int i = 0; i < children; i++) {
            TreeNode<Integer> child = takeInput(sc);
            root.children.add(child);
        }
        return root;
    }

    public static void print(TreeNode<Integer> root) {
        String s = root.data + ":";
        for (int i = 0; i < root.children.size(); i++) {
            s += root.children.get(i).data + ", ";
        }
        System.out.println(s);
        for (int i = 0; i < root.children.size(); i++) {
            print(root.children.get(i));
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TreeNode<Integer> root = takeInput(sc);
        print(root);
        // TreeNode<Integer> n1 = new TreeNode<Integer>(4);
        // TreeNode<Integer> n2 = new TreeNode<Integer>(2);
        // TreeNode<Integer> n3 = new TreeNode<Integer>(3);
        // TreeNode<Integer> n4 = new TreeNode<Integer>(5);
        // TreeNode<Integer> n5 = new TreeNode<Integer>(6);
        // n1.children.add(n2);
        // n1.children.add(n3);
        // n1.children.add(n4);
        // n3.children.add(n5);
        // System.out.println(n1);
    }
}
