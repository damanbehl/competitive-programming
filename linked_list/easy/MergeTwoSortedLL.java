package linked_list.easy;

//https://leetcode.com/problems/merge-two-sorted-lists/
//https://www.codingninjas.com/codestudio/problems/merge-two-sorted-linked-lists_800332
import linked_list.concept.LinkedListUse;
import linked_list.concept.Node;

public class MergeTwoSortedLL {
    public static void main(String[] args) {
        Node<Integer> head = LinkedListUse.takeInput();
        Node<Integer> head2 = LinkedListUse.takeInput();
        Node<Integer> result = sortTwoLists(head, head2);
        LinkedListUse.print(result);
    }

    public static Node<Integer> sortTwoLists(Node<Integer> first, Node<Integer> second) {
        // Write your code here.
        Node<Integer> newHead = null;
        Node<Integer> tail = null;
        while (first != null && second != null) {
            if (newHead == null) {
                if (first.data.intValue() <= second.data.intValue()) {
                    newHead = first;
                    first = first.next;
                } else {
                    newHead = second;
                    second = second.next;
                }
                tail = newHead;
            } else {
                if (first.data.intValue() <= second.data.intValue()) {
                    tail.next = first;
                    first = first.next;
                } else {
                    tail.next = second;
                    second = second.next;
                }
                tail = tail.next;
            }
        }
        if (tail == null) {
            if (first == null && second == null) {
                return first;
            } else if (first == null) {
                return second;
            } else {
                return first;
            }
        }
        while (first != null) {
            tail.next = first;
            first = first.next;
            tail = tail.next;
        }
        while (second != null) {
            tail.next = second;
            second = second.next;
            tail = tail.next;
        }
        return newHead;
    }
}
