package linked_list.medium;

//https://practice.geeksforgeeks.org/problems/merge-sort-on-doubly-linked-list
public class MergeSortDLL {
    static Node sortDoubly(Node head) {
        // add your code here
        return mergeSort(head);
    }

    static Node mergeSort(Node head) {
        if (head != null && head.next != null) {
            Node slow = head;
            Node fast = head;
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            slow.prev.next = null;
            Node left = mergeSort(head);
            Node right = mergeSort(slow);
            return merge(left, right);
        } else {
            return head;
        }
    }

    static Node merge(Node headLt, Node headRt) {
        Node newHead = null;
        Node dummy = null;
        Node temp1 = headLt;
        Node temp2 = headRt;
        while (temp1 != null && temp2 != null) {
            if (newHead == null) {
                if (temp1.data < temp2.data) {
                    newHead = temp1;
                    temp1 = temp1.next;
                } else {
                    newHead = temp2;
                    temp2 = temp2.next;
                }
                dummy = newHead;
                dummy.prev = null;
            } else {
                if (temp1.data < temp2.data) {
                    temp1.prev = dummy;
                    dummy.next = temp1;
                    dummy = dummy.next;
                    temp1 = temp1.next;
                } else {
                    temp2.prev = dummy;
                    dummy.next = temp2;
                    dummy = dummy.next;
                    temp2 = temp2.next;
                }
            }
        }
        while (temp1 != null) {
            temp1.prev = dummy;
            dummy.next = temp1;
            dummy = dummy.next;
            temp1 = temp1.next;
        }
        while (temp2 != null) {
            temp2.prev = dummy;
            dummy.next = temp2;
            dummy = dummy.next;
            temp2 = temp2.next;
        }
        return newHead;
    }
}

class Node {
    int data;
    Node next, prev;

    Node(int data) {
        this.data = data;
        next = prev = null;
    }
}
