package linked_list.medium;

//https://www.codingninjas.com/codestudio/problems/reverse-list-in-k-groups_983644
//https://leetcode.com/problems/reverse-nodes-in-k-group/
/**
 * configured for leetcode
 * difference from CN is the remaining non-k nodes maintain order
 */
import linked_list.concept.Node;
import linked_list.concept.LinkedListUse;

public class KReverseLL {
    public static void main(String[] args) {
        Node<Integer> head = LinkedListUse.takeInput();
        head = kReverse(head, 3);
        LinkedListUse.print(head);
    }

    public static Node<Integer> kReverse(Node<Integer> head, int k) {
        Node<Integer> newHead = null;
        Node<Integer> prevHead = null;
        // write your code here
        while (head != null) {
            Node<Integer> prev = null;
            Node<Integer> current = head;
            Node<Integer> swap;
            int temp = k;
            while (current != null && temp > 0) {
                swap = current.next;
                current.next = prev;
                prev = current;
                current = swap;
                temp--;
            }
            // comment this for CN submission
            if (current == null && temp > 0) {
                current = prev;
                prev = null;
                swap = null;
                while (current != null) {
                    swap = current.next;
                    current.next = prev;
                    prev = current;
                    current = swap;
                }
                prevHead.next = head;
                break;
            }
            if (newHead == null) {
                newHead = prev;
            }
            if (prevHead != null) {
                prevHead.next = prev;
            }
            prevHead = head;
            head = current;

            temp = k;
        }
        return newHead;
    }
}
