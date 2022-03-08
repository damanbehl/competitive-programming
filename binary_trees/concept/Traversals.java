package binary_trees.concept;

public class Traversals {
    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = BinaryTreeUse.takeInputLevelWise();
        System.out.println("Inorder:\t");
        inorder(root);
        System.out.println();
        System.out.print("Preorder:\t");
        preorder(root);
        System.out.println();
        System.out.print("Post order:\t");
        postorder(root);
    }

    public static void inorder(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.data + ", ");
        inorder(root.right);
    }

    public static void preorder(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + ", ");
        preorder(root.left);
        preorder(root.right);
    }

    public static void postorder(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return;
        }
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data + ", ");
    }
}
