package linked_list.easy;

//https://practice.geeksforgeeks.org/problems/segregate-even-and-odd-nodes-in-a-linked-list5035
import linked_list.concept.LinkedListUse;
import linked_list.concept.Node;

public class SegragateEvenOdd {
    public static void main(String[] args) {
        Node<Integer> head = LinkedListUse.takeInput();
        LinkedListUse.print(head);
        SegragateEvenOdd ob = new SegragateEvenOdd();
        head = ob.divide(1, head);
        LinkedListUse.print(head);
    }

    Node<Integer> divide(int N, Node<Integer> head) {
        // code here
        Node<Integer> even = null;
        Node<Integer> evenTail = even;
        Node<Integer> odd = null;
        Node<Integer> oddTail = odd;

        while (head != null) {
            if (even == null || odd == null) {
                if (even == null && head.data % 2 == 0) {
                    even = head;
                    evenTail = even;
                    head = head.next;
                    continue;
                } else if (odd == null && head.data % 2 != 0) {
                    odd = head;
                    oddTail = odd;
                    head = head.next;
                    continue;
                }
            }
            if (head.data % 2 == 0) {
                evenTail.next = head;
                evenTail = evenTail.next;
            } else {
                oddTail.next = head;
                oddTail = oddTail.next;
            }
            head = head.next;
        }
        if (odd == null) {
            return even;
        }
        if (even == null) {
            return odd;
        }
        oddTail.next = null;
        evenTail.next = odd;
        return even;
    }
}
