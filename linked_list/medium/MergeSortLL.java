package linked_list.medium;

//https://leetcode.com/problems/sort-list
//https://www.codingninjas.com/codestudio/problems/mergesort-linked-list_630514
import linked_list.concept.LinkedListUse;
import linked_list.concept.Node;

public class MergeSortLL {
    public static void main(String[] args) {
        Node<Integer> head = LinkedListUse.takeInput();
        Node<Integer> result = mergeSort(head);
        LinkedListUse.print(result);
    }

    public static Node<Integer> mergeSort(Node<Integer> head) {
        // Write your code here.
        if (head.next != null) {
            Node<Integer> mid = findMid(head);
            head = mergeSort(head);
            mid = mergeSort(mid);
            return merge(head, mid);
        } else {
            return head;
        }
    }

    public static Node<Integer> findMid(Node<Integer> head) {
        Node<Integer> slowPtr = head;
        Node<Integer> fastPtr = head;
        Node<Integer> prevSlowPtr = head;
        while (fastPtr != null && fastPtr.next != null) {
            prevSlowPtr = slowPtr;
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
        }
        // snip snip
        prevSlowPtr.next = null;
        return slowPtr;
    }

    public static Node<Integer> merge(Node<Integer> first, Node<Integer> second) {
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
        if (first != null) {
            tail.next = first;
        }
        if (second != null) {
            tail.next = second;
        }
        return newHead;
    }
}
