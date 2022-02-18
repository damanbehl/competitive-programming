package linked_list.easy;

import linked_list.concept.Node;
import linked_list.concept.LinkedListUse;

public class ReverseLLIterative {
    public static void main(String[] args) {
        Node<Integer> head = LinkedListUse.takeInput();
        head = reverse(head);
        LinkedListUse.print(head);

    }

    public static Node<Integer> reverse(Node<Integer> head) {
        Node<Integer> temp;
        Node<Integer> current = head;
        Node<Integer> prev = null;
        while (current != null) {
            temp = current.next;
            current.next = prev;
            prev = current;
            current = temp;
        }
        return prev;
    }
}
