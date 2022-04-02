package binary_trees.medium;

//https://practice.geeksforgeeks.org/problems/binary-tree-to-dll
public class BTreeToDLL {
    static Node newRoot;

    public static void main(String[] args) {
    }

    static Node prev;

    // track of previous node because you never know which sub tree is going to be
    // null
    // thus if we do not, we might not be able to predict which root should precede
    // the current root
    Node bToDLL(Node root) {
        prev = new Node(-1);
        Node dummy = prev;
        bToDLLHelper(root);
        prev.right = null;
        Node head = dummy.right;
        head.left = null;
        return head;
    }

    void bToDLLHelper(Node root) {
        if (root == null) {
            return;
        }
        bToDLLHelper(root.left);
        prev.right = root;
        root.left = prev;
        prev = root;
        bToDLLHelper(root.right);
    }
}

// class Node
class Node {
    Node left, right;
    int data;

    Node(int d) {
        data = d;
        left = right = null;
    }

}