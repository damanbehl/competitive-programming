package bst.avl.concept;

import bst.avl.concept.Avl.Node;

public class AvlUse {
    public static void main(String[] args) {
        execute();
    }

    public static void execute() {
        int arr[] = { 10, 20, 30, 40, 50, 60, 70, 80, 90, 100 };
        Node root = null;

        for (int x : arr) {
            root = Avl.addData(root, x);
        }
        Avl.display(root);
        System.out.println("-----------------------------------------");
        for (int i = arr.length - 1; i >= 0; i--) {
            // System.out.println("========================================");
            root = Avl.deleteData(root, arr[i]);
            Avl.display(root);
            System.out.println("========================================");
        }

    }
}
