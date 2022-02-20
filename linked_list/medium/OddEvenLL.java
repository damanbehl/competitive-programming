package linked_list.medium;

//https://leetcode.com/problems/odd-even-linked-list/
import linked_list.concept.LinkedListUse;
import linked_list.concept.Node;

public class OddEvenLL {
    public static void main(String[] args) {
        Node<Integer> head = LinkedListUse.takeInput();
        LinkedListUse.print(head);
        OddEvenLL ob = new OddEvenLL();
        head = ob.oddEvenList(head);
        LinkedListUse.print(head);
    }

    public Node<Integer> oddEvenList(Node<Integer> head) {
        if (head == null || head.next == null) {
            return head;
        }
        int i = 3;
        Node<Integer> odd = head;
        Node<Integer> oddTail = odd;
        Node<Integer> even = odd.next;
        Node<Integer> evenTail = even;
        head = head.next.next;
        while (head != null) {
            if (i % 2 == 0) {
                evenTail.next = head;
                evenTail = evenTail.next;
            } else {
                oddTail.next = head;
                oddTail = oddTail.next;
            }
            head = head.next;
            i++;
        }
        evenTail.next = null;
        oddTail.next = even;
        return odd;
    }
}
