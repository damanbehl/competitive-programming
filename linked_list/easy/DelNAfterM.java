package linked_list.easy;

import linked_list.concept.Node;
import linked_list.concept.LinkedListUse;

public class DelNAfterM {
    public static void main(String[] args) {
        Node<Integer> head = LinkedListUse.takeInput();
        linkdelete(head, 1, 2);
        LinkedListUse.print(head);
    }

    static Node<Integer> linkdelete(Node<Integer> head, int M, int N) {
        // your code here
        int decM = M - 1;
        int decN = N;
        Node<Integer> temp = head;
        Node<Integer> tail = temp;
        head = head.next;
        while (head != null) {
            if (decM == 0 && decN == 0) {
                decM = M;
                decN = N;
            }
            if (decM > 0) {
                tail.next = head;
                tail = tail.next;
                decM--;
            } else
            // if (decN > 0)
            {
                decN--;
            }
            head = head.next;
        }
        tail.next = null;
        return temp;
    }
}