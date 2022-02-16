package linked_list.easy;

// source :cc
class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class Solution {
    public static Node uniqueSortedList(Node head) {
        // Write your code here.
        Node temp = head;
        while (temp != null) {
            if (temp.next != null && temp.data == temp.next.data) {
                temp.next = temp.next.next;
            } else {
                temp = temp.next;
            }
        }
        return head;
    }
}
