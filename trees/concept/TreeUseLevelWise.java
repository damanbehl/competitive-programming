package trees.concept;

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
    //levelwise
    public static void print_formatted(TreeNode<Integer> root) {
        QueueUsingLL<TreeNode<Integer>> queue = new QueueUsingLL<>();
        queue.enqueue(root);
        while (!queue.empty()) {
            int n = queue.size();
            System.out.println();
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
        }
    }

    public static void main(String[] args) {
        TreeNode<Integer> root = takeInput();
        print_formatted(root);
    }
}
