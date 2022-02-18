package linked_list.concept;

import linked_list.concept.Node;
import linked_list.concept.LinkedListUse;

public class InsertRecursively {
    public static void main(String[] args) {
        Node<Integer> head = LinkedListUse.takeInput();
        head = insert(head, 5, 33);
        LinkedListUse.print(head);
    }

    public static Node<Integer> insert(Node<Integer> head, int pos, int elem) {
        if (pos == 0) {
            Node<Integer> newNode = new Node<Integer>(elem);
            newNode.next = head;
            return newNode;
        }
        if (head == null) {
            return head;
        }
        head.next = insert(head.next, pos - 1, elem);
        return head;
    }
}
