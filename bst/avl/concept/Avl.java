package bst.avl.concept;

import exception.QueueEmptyException;
import queues.concept.QueueUsingLL;

public class Avl {
    public static class Node {
        int data = 0;
        int height = 0;
        // new node added, no left or right child so -1-(-1) = 0 balance
        int balance = 0;
        Node left = null;
        Node right = null;

        public Node(int data) {
            this.data = data;
        }

        public Node() {

        }
    }

    // going to update Heigh bal after insert delete ops
    // O(1) complexity on account of 2 * int size extra space per node
    public static void updateHeightBalance(Node node) {
        int lh = -1;
        int rh = -1;
        if (node.left != null)
            lh = node.left.height;
        if (node.right != null)
            rh = node.right.height;
        node.balance = lh - rh;
        node.height = Math.max(lh, rh) + 1;
    }

    // call rotation at every node int the path from root to node where we did
    // insertion or deletion
    public static Node getRotation(Node node) {
        updateHeightBalance(node);
        if (node.balance == 2) {// LL OR LR STRUCTURE
            if (node.left.balance == 1) {
                // LL
                return rightRotation(node);
            } else {
                // LR
                node.left = leftRotation(node.left);
                return rightRotation(node);
            }
        } else if (node.balance == -2) { // RR OR RL STRUCTURE
            if (node.right.balance == -1) {
                // RR
                return leftRotation(node);
            } else {
                // RL
                node.right = rightRotation(node.right);
                return leftRotation(node);
            }
        }
        return node;
    }

    // whilst handling possible subtrees on rotation
    public static Node leftRotation(Node A) {
        Node bNode = A.right;
        Node bLeft = bNode.left;

        bNode.left = A;
        A.right = bLeft;
        // after structural changes, the nodes which were rotated
        // or the node which had it's child updated, that node's height/balance
        // changes and the order in which we update those matters , since
        // A becomes child of B, first A has to be updated
        updateHeightBalance(A);
        updateHeightBalance(bNode);
        return bNode;
    }

    public static Node rightRotation(Node A) {
        Node bNode = A.left;
        Node bRight = bNode.right;

        bNode.right = A;
        A.left = bRight;

        updateHeightBalance(A);
        updateHeightBalance(bNode);
        return bNode;
    }

    // we are returning since the position of nodes changes after rotation
    // and updated reference has to be returned
    // no only does the current node's left and right may change but also for our
    // Predecessor
    public static Node addData(Node root, int data) {
        if (root == null) {
            return new Node(data);
        }
        if (data < root.data) {
            root.left = addData(root.left, data);
        } else if (data > root.data) {
            root.right = addData(root.right, data);
        }
        // check if rotation is required
        // check if tree becomes unbalanced and if so rotate it
        root = getRotation(root);
        return root;
    }

    public static void display(Node node) {
        if (node == null) {
            return;
        }
        QueueUsingLL<Node> pendingNodes = new QueueUsingLL<>();
        pendingNodes.enqueue(node);
        while (!pendingNodes.empty()) {
            try {
                Node current = pendingNodes.dequeue();
                String result = current.data + ": ";
                if (current.left != null) {
                    result = result + "L>" + current.left.data;
                    pendingNodes.enqueue(current.left);
                }
                if (current.right != null) {
                    result = result + ", R>" + current.right.data;
                    pendingNodes.enqueue(current.right);
                }
                System.out.println(result);
            } catch (QueueEmptyException e) {
                e.printStackTrace();
            }
        }
    }

    public static Node deleteData(Node root, int data) {
        if (root == null) {
            return null;
        }
        if (data < root.data) {
            root.left = deleteData(root.left, data);
        } else if (data > root.data) {
            root.right = deleteData(root.right, data);
        } else if (data == root.data) {
            if (root.right == null) {
                return root.left;
            } else if (root.left == null) {
                return root.right;
            } else {
                Node subRoot = root.right;
                while (subRoot.left != null) {
                    subRoot = subRoot.left;
                }
                root.data = subRoot.data;
                root.right = deleteData(root.right, subRoot.data);
                // IMP: cannot directly return here, since nodes where interchnaged
                // height balance might have changed and hence before returning, check for
                // possible rotations
                // return root;
            }
        }
        // flip 148 to see difference
        root = getRotation(root);
        return root;
    }
}