package linked_list.medium;

import linked_list.concept.Node;
import linked_list.concept.LinkedListUse;

public class BubbleSortLL {
    public static void main(String[] args) {
        Node<Integer> head = LinkedListUse.takeInput();
        int length = LinkedListUse.length(head);
        head = bubbleSort(head, length);
        LinkedListUse.print(head);
    }

    public static Node<Integer> bubbleSort(Node<Integer> head, int length) {
        if (length <= 1) {
            return head;
        }
        boolean status;
        do {
            Node<Integer> current = head;
            Node<Integer> next = head.next;
            Node<Integer> prev = null;
            Node<Integer> dummy = null;
            status = false;
            while (next != null) {
                if (current.data > next.data) {
                    status = true;
                    if (prev == null) {
                        dummy = next.next;
                        next.next = current;
                        current.next = dummy;
                        head = next;
                    } else {
                        dummy = next.next;
                        prev.next = next;
                        next.next = current;
                        current.next = dummy;
                    }
                    prev = next;
                    next = current.next;
                } else {
                    prev = current;
                    current = next;
                    next = next.next;
                }
            }
        } while (status);
        return head;
    }
}
