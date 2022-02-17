package linked_list.easy;
//https://www.codingninjas.com/codestudio/problems/print-reverse-linkedlist_564
import linked_list.concept.Node;

public class PrintReverseLL {

    public static void printReverse(Node<Integer> root) {
        // Your code goes here
        String result = "";
        while (root != null) {
            result = root.data + " " + result;
            root = root.next;
        }
        System.out.print(result);
    }

    // slower by a few ms due to stack frames
    public static void printReverseRec(Node<Integer> root) {
        if (root == null)
            return;
        printReverseRec(root.next);
        System.out.print(root.data + " ");

    }

}
