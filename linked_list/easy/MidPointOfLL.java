package linked_list.easy;

import linked_list.concept.LinkedListUse;
import linked_list.concept.Node;

public class MidPointOfLL {
    public static void main(String[] args) {
        Node<Integer> head = LinkedListUse.takeInput();
        System.out.println();
    }

    public static Node<Integer> getMiddle(Node<Integer> head) {
        Node<Integer> slow = head;
        Node<Integer> fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

}
