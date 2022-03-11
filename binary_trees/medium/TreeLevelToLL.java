package binary_trees.medium;

//https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
import java.util.LinkedList;
import java.util.Queue;

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};

public class TreeLevelToLL {
    public static void main(String[] args) {

    }

    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        Queue<Node> pendingNodes = new LinkedList<Node>();
        pendingNodes.add(root);
        while (!pendingNodes.isEmpty()) {
            Node front = pendingNodes.peek();
            int n = pendingNodes.size();
            for (int i = 0; i < n; i++) {
                front = pendingNodes.poll();
                if (front == null) {
                    continue;
                }
                front.next = pendingNodes.peek();
                pendingNodes.add(front.left);
                pendingNodes.add(front.right);
            }
            if (front != null) {
                front.next = null;
            }
        }
        return root;
    }
}
