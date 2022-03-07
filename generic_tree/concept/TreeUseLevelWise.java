package generic_tree.concept;

import java.util.Scanner;

import exception.QueueEmptyException;
import queues.concept.QueueUsingLL;

public class TreeUseLevelWise {
    public static TreeNode<Integer> takeInput() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter root node");
        int data = sc.nextInt();
        TreeNode<Integer> root = new TreeNode<Integer>(data);
        QueueUsingLL<TreeNode<Integer>> queue = new QueueUsingLL<TreeNode<Integer>>();
        queue.enqueue(root);
        while (!queue.empty()) {
            try {
                TreeNode<Integer> frontNode = queue.dequeue();
                System.out.println("Enter number of children for Node" + frontNode.data);
                int children = sc.nextInt();
                for (int i = 0; i < children; i++) {
                    System.out.println("Enter " + (i + 1) + "th child");
                    int childData = sc.nextInt();
                    TreeNode<Integer> ithChild = new TreeNode<Integer>(childData);
                    frontNode.children.add(ithChild);
                    queue.enqueue(ithChild);
                }
            } catch (QueueEmptyException e) {
                e.printStackTrace();
            }
        }
        return root;
    }

    public static void print(TreeNode<Integer> root) {
        QueueUsingLL<TreeNode<Integer>> queue = new QueueUsingLL<>();
        queue.enqueue(root);
        while (!queue.empty()) {
            TreeNode<Integer> frontNode;
            try {
                frontNode = queue.dequeue();
                System.out.println(frontNode.data + ", ");
                for (int i = 0; i < frontNode.children.size(); i++) {
                    queue.enqueue(frontNode.children.get(i));

                }

            } catch (QueueEmptyException e) {
                e.printStackTrace();
            }

        }
    }

    // levelwise
    public static void print_formatted(TreeNode<Integer> root) {
        QueueUsingLL<TreeNode<Integer>> queue = new QueueUsingLL<>();
        queue.enqueue(root);
        while (!queue.empty()) {
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                try {
                    TreeNode<Integer> frontNode = queue.dequeue();
                    System.out.print(frontNode.data + ", ");
                    for (int j = 0; j < frontNode.children.size(); j++) {
                        queue.enqueue(frontNode.children.get(j));
                    }
                } catch (QueueEmptyException e) {
                    e.printStackTrace();
                }
            }
            System.out.println();
        }
    }

    public static int noOfNodes(TreeNode<Integer> root) {
        // edge case not base case
        if (root == null) {
            return 0;
        }
        // if (root.children.size() == 0) {
        // return 1;
        // }
        int total = 1;
        for (int i = 0; i < root.children.size(); i++) {
            total += noOfNodes(root.children.get(i));
        }
        return total;
    }

    public static TreeNode<Integer> findLargestNode(TreeNode<Integer> root) {
        if (root == null) {
            return null;
        }
        TreeNode<Integer> largest = root;
        for (int i = 0; i < root.children.size(); i++) {
            TreeNode<Integer> child = findLargestNode(root.children.get(i));
            if (child.data > largest.data) {
                largest = child;
            }
        }
        return largest;
    }

    // https://leetcode.com/problems/maximum-depth-of-n-ary-tree/
    public static int height(TreeNode<Integer> root) {
        if (root == null) {
            return 0;
        }
        int maxSubHeight = 0;
        for (int i = 0; i < root.children.size(); i++) {
            int subHeight = height(root.children.get(i));
            if (subHeight > maxSubHeight) {
                maxSubHeight = subHeight;
            }
        }
        return maxSubHeight + 1;
    }

    public static void main(String[] args) {
        TreeNode<Integer> root = takeInput();
        print_formatted(root);
        TreeNode<Integer> largest = findLargestNode(root);
        System.out.println("largest is " + largest.data);
        System.out.println("No of nodes in tree are " + noOfNodes(root));
        System.out.println("height of tree is " + height(root));
    }
}
