package binary_trees.easy;

//https://www.codingninjas.com/codestudio/problems/name_2035933
import java.util.ArrayList;

class BinaryTreeNode<T> {
    T data;
    BinaryTreeNode<T> left;
    BinaryTreeNode<T> right;

    public BinaryTreeNode(T data) {
        this.data = data;
    }
}

public class PostOrderTrav {
    public static ArrayList<Integer> postorderTraversal(BinaryTreeNode<Integer> root) {
        // Write your code here
        ArrayList<Integer> al = new ArrayList<>();
        postorderTraversalHelper(root, al);
        return al;
    }

    public static void postorderTraversalHelper(BinaryTreeNode<Integer> root, ArrayList<Integer> al) {
        if (root == null) {
            return;
        }
        if (root.left != null && root.right != null) {
            postorderTraversalHelper(root.left, al);
            postorderTraversalHelper(root.right, al);
        } else if (root.left != null) {
            postorderTraversalHelper(root.left, al);
        } else {
            postorderTraversalHelper(root.right, al);
        }
        al.add(root.data);
    }
}
