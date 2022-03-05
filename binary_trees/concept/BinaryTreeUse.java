package binary_trees.concept;

import java.util.Scanner;

import exception.QueueEmptyException;
import queues.concept.QueueUsingLL;

public class BinaryTreeUse {
    public static void main(String[] args) {
        // BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(2);
        // BinaryTreeNode<Integer> left = new BinaryTreeNode<Integer>(3);
        // BinaryTreeNode<Integer> right = new BinaryTreeNode<Integer>(4);
        // root.left = left;
        // root.right = right;
        // System.out.println(" empty");
        // Scanner sc = new Scanner(System.in);
        // BinaryTreeNode<Integer> root = takeInput(sc);
        BinaryTreeNode<Integer> root = takeInputLevelWise();
        // printTree(root);
        System.out.println("Printing levelwise");
        printLevelWise(root);
        System.out.println(height(root, 0));
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

    public static BinaryTreeNode<Integer> takeInputLevelWise() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter root data");
        int rootData = sc.nextInt();
        BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootData);
        QueueUsingLL<BinaryTreeNode<Integer>> pendingNodes = new QueueUsingLL<>();
        pendingNodes.enqueue(root);
        while (!pendingNodes.empty()) {
            BinaryTreeNode<Integer> front;
            try {
                front = pendingNodes.dequeue();
            } catch (QueueEmptyException e) {
                return null;
            }
            System.out.println("Enter left child of " + front.data);
            int leftData = sc.nextInt();
            if (leftData != -1) {
                BinaryTreeNode<Integer> leftChild = new BinaryTreeNode<Integer>(leftData);
                pendingNodes.enqueue(leftChild);
                front.left = leftChild;
            }
            System.out.println("Enter right child of " + front.data);
            int rightData = sc.nextInt();
            if (rightData != -1) {
                BinaryTreeNode<Integer> rightChild = new BinaryTreeNode<Integer>(rightData);
                pendingNodes.enqueue(rightChild);
                front.right = rightChild;
            }
        }
        return root;
    }

    public static int height(BinaryTreeNode<Integer> root, int x) {
        // code here
        if (root == null) {
            return x;
        }
        ++x;
        System.out.println("value of x" + x);
        int leftHeight = height(root.left, x);
        int rightHeight = height(root.right, x);
        return Math.max(leftHeight, rightHeight);
    }

    public static void printLevelWise(BinaryTreeNode<Integer> root) {
        QueueUsingLL<BinaryTreeNode<Integer>> pendingNodes = new QueueUsingLL<>();
        pendingNodes.enqueue(root);
        while (!pendingNodes.empty()) {
            BinaryTreeNode<Integer> front;
            try {
                front = pendingNodes.dequeue();
            } catch (QueueEmptyException e) {
                return;
            }
            String current = front.data + " :";
            if (front.left != null) {
                pendingNodes.enqueue(front.left);
                current += "L>" + front.left.data + ", ";
            }
            if (front.right != null) {
                pendingNodes.enqueue(front.right);
                current += "R>" + front.right.data + ", ";
            }
            System.out.println(current);
        }
    }
}
