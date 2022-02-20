package linked_list.concept;

import linked_list.concept.LinkedListUse;
import linked_list.concept.Node;

public class DeleteRecursively {
    public static void main(String[] args) {
        Node<Integer> head = LinkedListUse.takeInput();
        Node<Integer> result = deleteRecursively(head, 2);
        LinkedListUse.print(result);
    }

    public static Node<Integer> deleteRecursively(Node<Integer> head, int pos) {
        if (head == null) {
            return head;
        }
        if (pos == 0) {
            return head.next;
        }
        head.next = deleteRecursively(head.next, pos - 1);
        return head;
    }
}
